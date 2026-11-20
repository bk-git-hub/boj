import sys, io, traceback


def _norm(t):
    lines = t.replace('\r', '').rstrip('\n').split('\n')
    return '\n'.join(l.rstrip() for l in lines).strip('\n')


def run_case(setup, src, stdin_text, check, show, out_expect, use_out):
    res = {'ok': False, 'stdout': '', 'error': '', 'kind': '', 'msg': '',
           'name': '', 'stage': '', 'line': 0, 'shown': ''}
    buf = io.StringIO()
    lines = stdin_text.split('\n') if stdin_text else []
    state = {'i': 0}

    def fake_input(prompt=''):
        if state['i'] >= len(lines):
            raise EOFError('no more input')
        v = lines[state['i']]
        state['i'] += 1
        return v

    ns = {'__name__': '__main__', 'input': fake_input}
    old_out, old_in = sys.stdout, sys.stdin
    sys.stdin = io.StringIO(stdin_text or '')
    sys.stdout = buf
    stage = 'setup'
    try:
        if setup:
            exec(setup, ns)
        stage = 'user'
        exec(src, ns)
        stage = 'check'
        sys.stdout = old_out
        res['stdout'] = buf.getvalue()
        if show:
            res['shown'] = repr(eval(show, ns))
        if use_out:
            res['ok'] = _norm(res['stdout']) == _norm(out_expect)
        else:
            res['ok'] = bool(eval(check, ns))
    except SyntaxError as e:
        res['kind'] = type(e).__name__
        res['msg'] = str(getattr(e, 'msg', '') or e)
        res['line'] = int(getattr(e, 'lineno', 0) or 0)
        res['stage'] = stage
    except Exception as e:
        res['kind'] = type(e).__name__
        res['msg'] = str(e)
        res['stage'] = stage
        name = getattr(e, 'name', None)
        if isinstance(name, str):
            res['name'] = name
        ln = 0
        tb = e.__traceback__
        while tb is not None:
            ln = tb.tb_lineno
            tb = tb.tb_next
        res['line'] = int(ln or 0)
    finally:
        sys.stdout, sys.stdin = old_out, old_in
    if not res['stdout']:
        res['stdout'] = buf.getvalue()
    return res
