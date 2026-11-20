# 문제 은행(questions.py)과 템플릿을 합쳐서 페이지를 만든다.
#   ../coach-app/index.html : Vercel 배포용 (AI 코치가 /api/coach 서버 함수를 부름)
#   artifact.html           : claude.ai 아티팩트용 (AI 코치가 claude.use("sample")을 부름)
# 문제를 고친 뒤엔 python3 verify.py 로 모범 답안이 전부 통과하는지 먼저 확인할 것.
import json, sys, os
here = os.path.dirname(os.path.abspath(__file__))
sys.path.insert(0, here)
from questions import Q
tpl = open(os.path.join(here, 'template.html'), encoding='utf-8').read()
harness = open(os.path.join(here, 'harness_core.py'), encoding='utf-8').read()
keys = ['id', 'cat', 'q', 'setup', 'stdin', 'starter', 'check', 'out', 'show', 'expect', 'answer', 'hint']
js = json.dumps([{k: q[k] for k in keys} for q in Q], ensure_ascii=False).replace('</', '<\\/')
base = tpl.replace('__HARNESS__', harness).replace('__QUESTIONS_JSON__', js)
SKEL = ('<!doctype html><html><head><meta charset="utf-8"><meta name="viewport" content="width=device-width, initial-scale=1, viewport-fit=cover">'
        '<style>:root{color-scheme:light;padding-top:env(safe-area-inset-top);padding-bottom:env(safe-area-inset-bottom)}body{margin:0;font:14px system-ui}img{max-width:100%}[hidden]{display:none!important}</style>'
        '</head><body>')
open(os.path.join(here, 'artifact.html'), 'w', encoding='utf-8').write(base.replace('__COACH_MODE__', 'sample'))
open(os.path.join(here, '..', 'coach-app', 'index.html'), 'w', encoding='utf-8').write(SKEL + base.replace('__COACH_MODE__', 'api') + '</body></html>')
print('built artifact.html and ../coach-app/index.html')
