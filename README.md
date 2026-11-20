# 파이썬 코테 드릴

코테용 파이썬 문법을 폰으로 연습하는 웹앱. https://python-drill-beta.vercel.app

- **문제 풀기**: 자료형과 문법 80문제. 직접 친 코드를 브라우저 안의 파이썬(Brython)으로 실행해서 채점한다.
- **자유 실행**: 코드와 입력을 넣고 돌려보는 온라인 컴파일러.
- **AI 코치**: 문제, 내 코드, 실행 결과를 Claude에게 보내서 뭐가 문제인지 묻는다.

## 폴더
- `coach-app/`: Vercel에 배포되는 앱. `index.html`(페이지)와 `api/coach.js`(AI 코치 서버 함수).
- `drill-src/`: 문제 은행(`questions.py`), 페이지 템플릿, 채점 코드. `python3 verify.py`로 모범 답안을 검증하고 `python3 build.py`로 `coach-app/index.html`을 다시 만든다.

## Vercel 환경 변수
`ANTHROPIC_API_KEY`, `COACH_PASSWORD`. 바꾼 뒤에는 Redeploy가 필요하다.

예전 백준 자바 풀이는 git 기록에 남아 있다.
