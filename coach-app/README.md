# 파이썬 코테 드릴 (Vercel)

코테용 파이썬 문법 80문제 채점, 자유 실행, AI 코치가 들어 있는 정적 페이지와 서버 함수.

- `index.html`: 페이지 전체. 브라우저용 파이썬(Brython)으로 코드를 채점하고 실행한다. `drill-src/build.py`가 만든다.
- `api/coach.js`: AI 코치 서버 함수. Anthropic API(claude-opus-5-5)를 스트리밍으로 부른다.

## Vercel 환경 변수
- `ANTHROPIC_API_KEY`: Anthropic Console에서 만든 API 키
- `COACH_PASSWORD`: 페이지에서 AI 코치를 쓸 때 입력하는 비밀번호 (남이 크레딧을 쓰지 못하게 막음)

환경 변수를 바꾼 뒤에는 Redeploy를 해야 적용된다.
