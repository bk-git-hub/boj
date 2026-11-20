import sys
import os; sys.path.insert(0, os.path.dirname(os.path.abspath(__file__)))
from harness_core import run_case
from questions import Q
from collections import Counter

bad = 0
ids = [q['id'] for q in Q]
dup = [k for k, v in Counter(ids).items() if v > 1]
if dup: print('중복 id', dup); bad += 1
for q in Q:
    use_out = q['out'] is not None
    def run(src):
        return run_case(q['setup'], src, q['stdin'], q['check'], q['show'], q['out'] or '', use_out)
    r = run(q['answer'])
    if not r['ok']:
        bad += 1; print('정답 실패', q['id'], r)
    e = run('')
    if e['ok']:
        bad += 1; print('빈 코드 통과', q['id'])
    if q['starter']:
        s = run(q['starter'])
        if s['ok']:
            bad += 1; print('함정 코드가 통과', q['id'])
        else:
            print('함정', q['id'], '→', s['kind'] or ('오답 ' + s['shown']))
print('문제 수', len(Q), '카테고리', dict(Counter(q['cat'] for q in Q)))
print('문제 있음' if bad else '전부 OK')
