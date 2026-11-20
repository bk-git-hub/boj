# 문제 은행. 필드:
# id, cat, q(문제), setup(미리 주어진 코드), stdin(입력), starter(에디터에 미리 들어갈 코드),
# check(채점식) 또는 out(기대 출력), show(내 값 보여줄 식), expect(기대값 설명), answer(모범답안), hint

Q = []


def add(**kw):
    base = dict(setup='', stdin='', starter='', check='', out=None, show='', expect='', hint='')
    base.update(kw)
    Q.append(base)


# ───────────── 입력 ─────────────
C = '입력'
add(id='in1', cat=C, q='한 줄에 정수 하나가 들어와요. 정수로 받아서 n에 담아요.',
    stdin='42', check='n == 42', show='n', expect='42',
    answer='n = int(input())',
    hint='input()은 문자열을 돌려줘요. int()로 감싸요.')
add(id='in2', cat=C, q='한 줄에 정수 두 개가 공백으로 들어와요. a, b에 각각 정수로 담아요.',
    stdin='3 7', check='a == 3 and b == 7', show='(a, b)', expect='(3, 7)',
    answer='a, b = map(int, input().split())',
    hint='split()으로 쪼개고 map(int, ...)로 한 번에 정수로 바꿔요.')
add(id='in3', cat=C, q='한 줄에 정수 여러 개가 들어와요. 정수 리스트 arr로 받아요.',
    stdin='5 1 4 2', check='arr == [5, 1, 4, 2]', show='arr', expect='[5, 1, 4, 2]',
    answer='arr = list(map(int, input().split()))',
    hint='map 결과는 리스트가 아니라서 list()로 감싸야 해요.')
add(id='in4', cat=C, q='첫 줄에 n, 다음 n줄에 정수들이 공백으로 들어와요. 2차원 리스트 grid로 받아요.',
    stdin='3\n1 2 3\n4 5 6\n7 8 9', check='grid == [[1, 2, 3], [4, 5, 6], [7, 8, 9]]', show='grid',
    expect='[[1, 2, 3], [4, 5, 6], [7, 8, 9]]',
    answer='n = int(input())\ngrid = [list(map(int, input().split())) for _ in range(n)]',
    hint='한 줄 받는 코드를 [ ... for _ in range(n)] 안에 넣어요.')
add(id='in5', cat=C, q='격자가 공백 없이 들어와요. 첫 줄에 n, 다음 n줄에 "0110" 같은 문자열. 각 칸을 정수로 바꾼 2차원 리스트 grid를 만들어요.',
    stdin='2\n01\n10', check='grid == [[0, 1], [1, 0]]', show='grid', expect='[[0, 1], [1, 0]]',
    answer='n = int(input())\ngrid = [list(map(int, input().strip())) for _ in range(n)]',
    hint='문자열에 map(int, ...)를 쓰면 글자 하나씩 정수로 바뀌어요.')
add(id='in6', cat=C, q='빠른 입력을 써요. sys.stdin.readline을 input으로 바꿔 쓰고, 문자열 한 줄을 줄바꿈 없이 s에 담아요.',
    stdin='hello\n', check="s == 'hello'", show='s', expect="'hello'",
    answer='import sys\ninput = sys.stdin.readline\ns = input().strip()',
    hint='readline은 끝의 \\n을 남겨요. 문자열이면 strip()을 붙여요.')
add(id='in7', cat=C, q='SWEA 기본 틀. 첫 줄에 T, 다음 T줄에 정수가 하나씩 와요. 각 정수의 2배를 "#번호 값" 형식으로 출력해요.',
    stdin='2\n3\n10', out='#1 6\n#2 20',
    answer='T = int(input())\nfor tc in range(1, T + 1):\n    x = int(input())\n    print(f"#{tc} {x * 2}")',
    hint='for tc in range(1, T + 1): 로 1번부터 세요. 출력은 f-string.')

# ───────────── 리스트 ─────────────
C = '리스트'
S = 'arr = [3, 1, 4, 1, 5]'
add(id='li1', cat=C, q='arr 맨 뒤에 9를 추가해요.', setup=S,
    check='arr == [3, 1, 4, 1, 5, 9]', show='arr', expect='[3, 1, 4, 1, 5, 9]',
    answer='arr.append(9)', hint='리스트.append(값)')
add(id='li2', cat=C, q='arr의 합을 s, 최댓값을 mx, 최솟값을 mn에 담아요.', setup=S,
    check='s == 14 and mx == 5 and mn == 1', show='(s, mx, mn)', expect='(14, 5, 1)',
    answer='s = sum(arr)\nmx = max(arr)\nmn = min(arr)', hint='sum, max, min. 이 이름들은 변수로 쓰면 안 돼요.')
add(id='li3', cat=C, q='arr를 정렬한 새 리스트를 b에 담아요. arr 자체는 그대로 둬요.', setup=S,
    check='b == [1, 1, 3, 4, 5] and arr == [3, 1, 4, 1, 5]', show='(b, arr)', expect='([1, 1, 3, 4, 5], [3, 1, 4, 1, 5])',
    answer='b = sorted(arr)', hint='sorted()는 새 리스트, .sort()는 원본을 바꿔요.')
add(id='li4', cat=C, q='arr 자체를 큰 순서(내림차순)로 정렬해요.', setup=S,
    check='arr == [5, 4, 3, 1, 1]', show='arr', expect='[5, 4, 3, 1, 1]',
    answer='arr.sort(reverse=True)', hint='reverse=True')
add(id='li5', cat=C, q='arr를 뒤집은 새 리스트를 r에 담아요.', setup=S,
    check='r == [5, 1, 4, 1, 3]', show='r', expect='[5, 1, 4, 1, 3]',
    answer='r = arr[::-1]', hint='슬라이싱 [::-1]')
add(id='li6', cat=C, q='값 1이 몇 개인지 c에, 값 4가 몇 번째에 있는지(0부터) i에 담아요.', setup=S,
    check='c == 2 and i == 2', show='(c, i)', expect='(2, 2)',
    answer='c = arr.count(1)\ni = arr.index(4)', hint='.count(값), .index(값)')
add(id='li7', cat=C, q='arr의 앞 3개만 담은 리스트 front, 마지막 2개만 담은 리스트 back을 만들어요.', setup=S,
    check='front == [3, 1, 4] and back == [1, 5]', show='(front, back)', expect='([3, 1, 4], [1, 5])',
    answer='front = arr[:3]\nback = arr[-2:]', hint='[:3]은 0,1,2번. [-2:]는 뒤에서 2개.')
add(id='li8', cat=C, q='arr의 각 값을 제곱한 리스트 sq를 한 줄로 만들어요.', setup=S,
    check='sq == [9, 1, 16, 1, 25]', show='sq', expect='[9, 1, 16, 1, 25]',
    answer='sq = [x * x for x in arr]', hint='[계산식 for x in arr]')
add(id='li9', cat=C, q='arr에서 홀수만 골라 리스트 odds를 만들어요.', setup=S,
    check='odds == [3, 1, 1, 5]', show='odds', expect='[3, 1, 1, 5]',
    answer='odds = [x for x in arr if x % 2 == 1]', hint='[x for x in arr if 조건]')

# ───────────── 2차원 리스트 ─────────────
C = '2차원 리스트'
add(id='g1', cat=C, q='0으로 채운 3행 4열 board를 만들어요. 각 줄이 서로 다른 리스트여야 해요.',
    check='board == [[0] * 4 for _ in range(3)] and board[0] is not board[1]', show='board',
    expect='[[0, 0, 0, 0], [0, 0, 0, 0], [0, 0, 0, 0]] (줄마다 따로)',
    answer='board = [[0] * 4 for _ in range(3)]',
    hint='[[0] * 4] * 3은 같은 줄을 3번 가리켜서 안 돼요.')
G = 'grid = [[1, 2, 3],\n        [4, 5, 6]]'
add(id='g2', cat=C, q='grid의 1행 2열(0부터 셈) 값을 v에 담아요.', setup=G,
    check='v == 6', show='v', expect='6', answer='v = grid[1][2]', hint='grid[행][열]')
add(id='g3', cat=C, q='grid 전체 칸의 합을 total에 담아요.', setup=G,
    check='total == 21', show='total', expect='21',
    answer='total = sum(sum(row) for row in grid)', hint='줄마다 sum 하고 그걸 다시 sum.')
add(id='g4', cat=C, q='grid의 행 수를 n, 열 수를 m에 담아요.', setup=G,
    check='n == 2 and m == 3', show='(n, m)', expect='(2, 3)',
    answer='n = len(grid)\nm = len(grid[0])', hint='len(grid)는 줄 수, len(grid[0])은 한 줄의 칸 수.')
add(id='g5', cat=C,
    q='(r, c)의 상하좌우 칸 중 격자 안에 있는 좌표만 (행, 열) 튜플로 nb 리스트에 담아요. 순서는 dr, dc 순서(상, 하, 좌, 우) 그대로.',
    setup='N, M = 3, 3\nr, c = 0, 2\ndr = [-1, 1, 0, 0]\ndc = [0, 0, -1, 1]',
    check='nb == [(1, 2), (0, 1)]', show='nb', expect='[(1, 2), (0, 1)]',
    answer='nb = []\nfor d in range(4):\n    nr, nc = r + dr[d], c + dc[d]\n    if 0 <= nr < N and 0 <= nc < M:\n        nb.append((nr, nc))',
    hint='nr, nc를 계산하고 0 <= nr < N and 0 <= nc < M 일 때만 추가.')
add(id='g6', cat=C, q='grid를 시계방향으로 90도 돌린 2차원 리스트 rot를 만들어요.', setup=G,
    check='rot == [[4, 1], [5, 2], [6, 3]]', show='rot', expect='[[4, 1], [5, 2], [6, 3]]',
    answer='rot = [list(row) for row in zip(*grid[::-1])]',
    hint='줄 순서를 뒤집고(grid[::-1]) zip(*...)으로 세로줄을 묶어요. for문으로는 rot[i][j] = grid[n-1-j][i].')

# ───────────── 문자열 ─────────────
C = '문자열'
add(id='s1', cat=C, q='카드 s에서 첫 글자를 suit, 나머지를 정수로 바꿔 num에 담아요.', setup='s = "H10"',
    check="suit == 'H' and num == 10", show='(suit, num)', expect="('H', 10)",
    answer='suit = s[0]\nnum = int(s[1:])', hint='s[1:]은 1번부터 끝까지. 두 자리 숫자도 통째로.')
add(id='s2', cat=C, q='s가 회문(앞뒤가 같은 글자)이면 True가 되는 is_pal을 만들어요.', setup='s = "level"',
    check='is_pal == True', show='is_pal', expect='True',
    answer='is_pal = s == s[::-1]', hint='뒤집은 것과 같은지 비교.')
add(id='s3', cat=C, q='s를 공백으로 쪼갠 리스트 words를 만들어요.', setup='s = "red green  blue"',
    check="words == ['red', 'green', 'blue']", show='words', expect="['red', 'green', 'blue']",
    answer='words = s.split()', hint='split()은 공백이 여러 개여도 알아서 쪼개요.')
add(id='s4', cat=C, q='parts를 이어 붙인 문자열 t를 만들어요.', setup="parts = ['2', '0', '2', '6']",
    check="t == '2026'", show='t', expect="'2026'",
    answer="t = ''.join(parts)", hint="'붙일 글자'.join(리스트)")
add(id='s5', cat=C, q="s에서 'a'의 개수를 c에, 'n'이 처음 나오는 위치를 i에 담아요.", setup='s = "banana"',
    check='c == 3 and i == 2', show='(c, i)', expect='(3, 2)',
    answer="c = s.count('a')\ni = s.find('n')", hint='.count(), .find() (없으면 -1)')
add(id='s6', cat=C, q="s를 전부 대문자로 바꾼 u, 'l'을 'L'로 바꾼 r을 만들어요.", setup='s = "Hello"',
    check="u == 'HELLO' and r == 'HeLLo'", show='(u, r)', expect="('HELLO', 'HeLLo')",
    answer="u = s.upper()\nr = s.replace('l', 'L')", hint='.upper(), .replace(옛것, 새것)')
add(id='s7', cat=C, q="s의 두 번째 글자(1번)를 'X'로 바꾼 문자열 t를 만들어요. 문자열은 한 글자만 직접 바꿀 수 없어요.", setup='s = "abc"',
    check="t == 'aXc'", show='t', expect="'aXc'",
    answer="arr = list(s)\narr[1] = 'X'\nt = ''.join(arr)", hint='list(s)로 바꿔서 고치고 join으로 붙여요.')
add(id='s8', cat=C, q="'A'를 5번 반복한 문자열 t를 만들어요.",
    check="t == 'AAAAA'", show='t', expect="'AAAAA'",
    answer="t = 'A' * 5", hint='문자열 * 숫자')
add(id='s9', cat=C, q='s 양 끝의 공백과 줄바꿈을 지운 t를 만들어요.', setup='s = "  hi \\n"',
    check="t == 'hi'", show='t', expect="'hi'",
    answer='t = s.strip()', hint='.strip()')
add(id='s10', cat=C, q='s를 10글자씩 잘라서 lines 리스트에 담아요. 마지막 조각은 10글자보다 짧을 수 있어요.',
    setup='s = "A" * 10 + "B" * 7 + "C" * 5',
    check="lines == ['AAAAAAAAAA', 'BBBBBBBCCC', 'CC']", show='lines', expect="['AAAAAAAAAA', 'BBBBBBBCCC', 'CC']",
    answer='lines = [s[i:i+10] for i in range(0, len(s), 10)]',
    hint='range(0, len(s), 10)은 0, 10, 20... 슬라이싱은 끝을 넘어도 에러 없어요.')

# ───────────── 집합 ─────────────
C = '집합'
add(id='st1', cat=C, q='arr에서 서로 다른 값이 몇 개인지 k에 담아요.', setup='arr = [3, 1, 3, 2, 1]',
    check='k == 3', show='k', expect='3', answer='k = len(set(arr))', hint='set()은 중복을 지워요.')
add(id='st2', cat=C, q='빈 집합 seen을 만들고 좌표 (2, 3)을 넣어요.',
    check='seen == {(2, 3)}', show='seen', expect='{(2, 3)}',
    answer='seen = set()\nseen.add((2, 3))', hint='{}는 빈 딕셔너리예요. 빈 집합은 set().')
add(id='st3', cat=C, q='a와 b의 교집합 i, 합집합 u, a에만 있는 것 d를 만들어요.', setup='a = {1, 2, 3}\nb = {2, 3, 4}',
    check='i == {2, 3} and u == {1, 2, 3, 4} and d == {1}', show='(i, u, d)', expect='({2, 3}, {1, 2, 3, 4}, {1})',
    answer='i = a & b\nu = a | b\nd = a - b', hint='& 교집합, | 합집합, - 차집합')
add(id='st4', cat=C, q='좌표 (1, 2)가 seen에 있으면 True인 visited를 만들어요.', setup='seen = {(0, 0), (1, 2)}',
    check='visited == True', show='visited', expect='True',
    answer='visited = (1, 2) in seen', hint='값 in 집합')

# ───────────── 딕셔너리 ─────────────
C = '딕셔너리'
add(id='d1', cat=C, q="d에서 'D'의 값을 v에, 없는 키 'L'은 기본값 0으로 w에 담아요.", setup="d = {'U': -1, 'D': 1}",
    check='v == 1 and w == 0', show='(v, w)', expect='(1, 0)',
    answer="v = d['D']\nw = d.get('L', 0)", hint="d.get(키, 기본값)은 키가 없어도 에러가 안 나요.")
add(id='d2', cat=C, q='Counter 없이 s의 글자별 개수 딕셔너리 cnt를 만들어요.', setup='s = "banana"',
    check="cnt == {'b': 1, 'a': 3, 'n': 2}", show='cnt', expect="{'b': 1, 'a': 3, 'n': 2}",
    answer='cnt = {}\nfor ch in s:\n    cnt[ch] = cnt.get(ch, 0) + 1', hint='cnt[ch] = cnt.get(ch, 0) + 1')
add(id='d3', cat=C, q='Counter로 s의 글자별 개수 cnt를 만들고, 제일 많이 나온 글자를 top에 담아요.', setup='s = "banana"',
    check="cnt['a'] == 3 and cnt['n'] == 2 and top == 'a'", show='top', expect="'a'",
    answer='from collections import Counter\ncnt = Counter(s)\ntop = cnt.most_common(1)[0][0]',
    hint='most_common(1)은 [(글자, 개수)] 모양이에요.')
add(id='d4', cat=C, q='nums에서 숫자별 개수를 세서, 개수만 큰 순서로 정렬한 리스트 pattern을 만들어요. (족보 판정)', setup='nums = [10, 10, 3, 3, 9]',
    check='pattern == [2, 2, 1]', show='pattern', expect='[2, 2, 1]',
    answer='from collections import Counter\npattern = sorted(Counter(nums).values(), reverse=True)',
    hint='Counter(...).values()로 개수만 꺼내요.')
add(id='d5', cat=C, q='d의 키와 값을 "a 3"처럼 한 줄씩 출력해요.', setup="d = {'a': 3, 'b': 1}",
    out='a 3\nb 1', answer='for k, v in d.items():\n    print(k, v)', hint='for 키, 값 in d.items():')
add(id='d6', cat=C, q='월별 일수 리스트 days를 만들어요. days[1]이 31, days[2]가 28, ... days[12]가 31. 0번 칸은 0.',
    check='days == [0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31]', show='days',
    expect='[0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31]',
    answer='days = [0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31]',
    hint='맨 앞에 0을 넣어서 월 번호랑 칸 번호를 맞춰요.')

# ───────────── 튜플·정렬 ─────────────
C = '튜플·정렬'
add(id='t1', cat=C, q='pos를 r, c로 풀어요.', setup='pos = (2, 5)',
    check='r == 2 and c == 5', show='(r, c)', expect='(2, 5)', answer='r, c = pos', hint='a, b = 튜플')
P = "people = [(3, 'b'), (1, 'z'), (3, 'a')]"
add(id='t2', cat=C, q='people을 첫 번째 값 기준으로(같으면 두 번째 값으로) 정렬한 s1을 만들어요.', setup=P,
    check="s1 == [(1, 'z'), (3, 'a'), (3, 'b')]", show='s1', expect="[(1, 'z'), (3, 'a'), (3, 'b')]",
    answer='s1 = sorted(people)', hint='튜플은 기본 정렬이 첫 값, 다음 값 순서예요.')
add(id='t3', cat=C, q='people을 두 번째 값(글자) 기준으로 정렬한 s2를 만들어요.', setup=P,
    check="s2 == [(3, 'a'), (3, 'b'), (1, 'z')]", show='s2', expect="[(3, 'a'), (3, 'b'), (1, 'z')]",
    answer='s2 = sorted(people, key=lambda x: x[1])', hint='key=lambda x: x[1]')
add(id='t4', cat=C, q='scores를 점수 높은 순, 점수가 같으면 이름 순으로 정렬한 ranked를 만들어요.',
    setup="scores = [('kim', 90), ('lee', 95), ('park', 90)]",
    check="ranked == [('lee', 95), ('kim', 90), ('park', 90)]", show='ranked',
    expect="[('lee', 95), ('kim', 90), ('park', 90)]",
    answer='ranked = sorted(scores, key=lambda x: (-x[1], x[0]))', hint='숫자 앞에 -를 붙이면 내림차순.')
add(id='t5', cat=C, q='words를 길이 순으로 정렬한 w를 만들어요.', setup="words = ['ccc', 'a', 'bb']",
    check="w == ['a', 'bb', 'ccc']", show='w', expect="['a', 'bb', 'ccc']",
    answer='w = sorted(words, key=len)', hint='key=len')
add(id='t6', cat=C, q='people을 for문으로 돌면서 "b 3"처럼 (글자 숫자) 순서로 한 줄씩 출력해요.', setup=P,
    out='b 3\nz 1\na 3', answer='for num, ch in people:\n    print(ch, num)', hint='for num, ch in people: 로 바로 풀어요.')
add(id='t7', cat=C, q='people의 0번째 짝의 두 번째 값을 x에 담아요.', setup=P,
    check="x == 'b'", show='x', expect="'b'", answer='x = people[0][1]', hint='people[몇 번째 짝][짝 안에서 몇 번째]')

# ───────────── deque ─────────────
C = 'deque'
add(id='q1', cat=C, q='deque q를 만들고 1, 2, 3을 차례로 넣어요.',
    check='type(q).__name__ == "deque" and list(q) == [1, 2, 3]', show='list(q)', expect='[1, 2, 3]',
    answer='from collections import deque\nq = deque()\nq.append(1)\nq.append(2)\nq.append(3)',
    hint='from collections import deque')
add(id='q2', cat=C, q='q의 맨 앞에서 하나 꺼내 x에 담아요.', setup='from collections import deque\nq = deque([5, 6, 7])',
    check='x == 5 and list(q) == [6, 7]', show='(x, list(q))', expect='(5, [6, 7])',
    answer='x = q.popleft()', hint='BFS는 popleft(). pop()은 뒤에서 꺼내요.')
add(id='q3', cat=C, q='q가 빌 때까지 앞에서 꺼내면서, 꺼낸 순서대로 order 리스트에 담아요.',
    setup='from collections import deque\nq = deque([3, 1, 2])',
    check='order == [3, 1, 2] and len(q) == 0', show='order', expect='[3, 1, 2]',
    answer='order = []\nwhile q:\n    order.append(q.popleft())', hint='while q: 는 q가 비면 멈춰요.')

# ───────────── itertools ─────────────
C = 'itertools'
add(id='it1', cat=C, q='arr에서 2개를 순서 상관없이 고르는 모든 경우를 리스트 c로 만들어요.', setup='arr = [1, 2, 3]',
    check='c == [(1, 2), (1, 3), (2, 3)]', show='c', expect='[(1, 2), (1, 3), (2, 3)]',
    answer='from itertools import combinations\nc = list(combinations(arr, 2))', hint='combinations(리스트, 개수)')
add(id='it2', cat=C, q='arr에서 2개를 순서 있게 줄 세우는 모든 경우를 리스트 p로 만들어요.', setup='arr = [1, 2, 3]',
    check='p == [(1, 2), (1, 3), (2, 1), (2, 3), (3, 1), (3, 2)]', show='p',
    expect='[(1, 2), (1, 3), (2, 1), (2, 3), (3, 1), (3, 2)]',
    answer='from itertools import permutations\np = list(permutations(arr, 2))', hint='permutations(리스트, 개수)')
add(id='it3', cat=C, q='arr의 부분집합(공집합 포함) 중 합이 5 이하인 것이 몇 개인지 cnt에 담아요.', setup='arr = [3, 5, 2]',
    check='cnt == 5', show='cnt', expect='5',
    answer='from itertools import product\ncnt = 0\nfor pick in product([0, 1], repeat=len(arr)):\n    total = sum(arr[i] for i in range(len(arr)) if pick[i])\n    if total <= 5:\n        cnt += 1',
    hint='product([0, 1], repeat=n)은 "넣을까 말까"를 전부 만들어요.')
add(id='it4', cat=C, q='cards를 한 줄로 세워 만든 숫자 중 가장 큰 값을 best에 담아요.', setup='cards = [1, 4, 2]',
    check='best == 421', show='best', expect='421',
    answer="from itertools import permutations\nbest = max(int(''.join(map(str, p))) for p in permutations(cards))",
    hint='순열마다 글자로 바꿔 붙이고 int로 바꿔서 max.')

# ───────────── 내장 함수 ─────────────
C = '내장 함수'
add(id='b1', cat=C, q='enumerate로 "0 a"처럼 번호와 값을 한 줄씩 출력해요.', setup="arr = ['a', 'b', 'c']",
    out='0 a\n1 b\n2 c', answer='for i, x in enumerate(arr):\n    print(i, x)', hint='for i, x in enumerate(arr):')
add(id='b2', cat=C, q='zip으로 xs와 ys를 짝지은 리스트 pairs를 만들어요.', setup="xs = [1, 2]\nys = ['a', 'b']",
    check="pairs == [(1, 'a'), (2, 'b')]", show='pairs', expect="[(1, 'a'), (2, 'b')]",
    answer='pairs = list(zip(xs, ys))', hint='list(zip(a, b))')
add(id='b3', cat=C, q='17을 5로 나눈 몫을 q, 나머지를 r에 한 줄로 담아요.',
    check='q == 3 and r == 2', show='(q, r)', expect='(3, 2)', answer='q, r = divmod(17, 5)', hint='divmod(a, b)는 (몫, 나머지)')
add(id='b4', cat=C, q='words에서 가장 긴 단어를 longest에 담아요.', setup="words = ['ab', 'abcd', 'abc']",
    check="longest == 'abcd'", show='longest', expect="'abcd'", answer='longest = max(words, key=len)', hint='max(리스트, key=기준)')
add(id='b5', cat=C, q='arr에 5보다 큰 값이 하나라도 있으면 True인 has_big, 전부 0보다 크면 True인 all_pos를 만들어요.', setup='arr = [3, 8, 1]',
    check='has_big == True and all_pos == True', show='(has_big, all_pos)', expect='(True, True)',
    answer='has_big = any(x > 5 for x in arr)\nall_pos = all(x > 0 for x in arr)', hint='any(...), all(...)')
add(id='b6', cat=C, q='정수 나눗셈으로 17 // 5를, 실수 나눗셈으로 17 / 5를 각각 a, b에 담아요.',
    check='a == 3 and b == 3.4', show='(a, b)', expect='(3, 3.4)', answer='a = 17 // 5\nb = 17 / 5', hint='// 몫, / 실수')

# ───────────── 진법·아스키 ─────────────
C = '진법·아스키'
add(id='n1', cat=C, q='6을 6자리 2진수 문자열 b로 바꿔요 (앞은 0으로 채움).',
    check="b == '000110'", show='b', expect="'000110'", answer="b = format(6, '06b')", hint="format(숫자, '06b')")
add(id='n2', cat=C, q="2진수 문자열 '01001100'을 정수 n으로 바꿔요.",
    check='n == 76', show='n', expect='76', answer="n = int('01001100', 2)", hint='int(문자열, 2)')
add(id='n3', cat=C, q="숫자 76을 글자 ch로, 글자 'a'를 숫자 code로 바꿔요.",
    check="ch == 'L' and code == 97", show='(ch, code)', expect="('L', 97)",
    answer="ch = chr(76)\ncode = ord('a')", hint='chr(숫자) → 글자, ord(글자) → 숫자')
add(id='n4', cat=C, q='255를 16진수 문자열 h로 바꿔요.',
    check="h == 'ff'", show='h', expect="'ff'", answer="h = format(255, 'x')", hint="format(숫자, 'x')")
add(id='n5', cat=C, q='ch에서 3칸 뒤 알파벳을 nxt에 담아요.', setup="ch = 'A'",
    check="nxt == 'D'", show='nxt', expect="'D'", answer='nxt = chr(ord(ch) + 3)', hint='ord로 숫자로 바꿔 더하고 chr로 되돌려요.')

# ───────────── 출력 ─────────────
C = '출력'
add(id='o1', cat=C, q='row를 "1 2 3"처럼 공백으로 띄워 출력해요.', setup='row = [1, 2, 3]',
    out='1 2 3', answer='print(*row)', hint='print(*리스트)')
add(id='o2', cat=C, q='"#1 42"를 출력해요. 숫자는 tc, ans 변수를 써요.', setup='tc = 1\nans = 42',
    out='#1 42', answer='print(f"#{tc} {ans}")', hint='f"#{tc} {ans}"')
add(id='o3', cat=C, q='첫 줄에 "#2", 다음 줄부터 board를 한 줄씩 공백으로 띄워 출력해요.', setup='board = [[1, 2], [3, 4]]\ntc = 2',
    out='#2\n1 2\n3 4', answer='print(f"#{tc}")\nfor row in board:\n    print(*row)', hint='#번호를 먼저 따로 한 줄 찍어요.')
add(id='o4', cat=C, q='x를 소수점 둘째 자리까지 출력해요.', setup='x = 3.14159',
    out='3.14', answer='print(f"{x:.2f}")', hint='f"{x:.2f}"')
add(id='o5', cat=C, q='words를 "a,b,c"처럼 쉼표로 이어 출력해요.', setup="words = ['a', 'b', 'c']",
    out='a,b,c', answer="print(','.join(words))", hint="','.join(...) 또는 print(*words, sep=',')")
add(id='o6', cat=C, q='줄바꿈 없이 "1 2 3 "처럼 이어서 출력해요 (for문으로 하나씩).', setup='row = [1, 2, 3]',
    out='1 2 3', answer="for x in row:\n    print(x, end=' ')", hint="print(x, end=' ')")

# ───────────── 함정 고치기 ─────────────
C = '함정 고치기'
add(id='f1', cat=C, q='board[0][0]만 1이 돼야 하는데 첫 열 전체가 1이 돼요. 고쳐요.',
    starter='board = [[0] * 3] * 3\nboard[0][0] = 1',
    check='board == [[1, 0, 0], [0, 0, 0], [0, 0, 0]]', show='board', expect='[[1, 0, 0], [0, 0, 0], [0, 0, 0]]',
    answer='board = [[0] * 3 for _ in range(3)]\nboard[0][0] = 1', hint='[[0] * 3] * 3은 같은 줄 3개예요.')
add(id='f2', cat=C, q='에러가 나요. 고쳐서 biggest에 9가 담기게 해요.',
    starter='nums = [4, 9, 2]\nmax = 0\nfor x in nums:\n    if x > max:\n        max = x\nbiggest = max(nums)',
    check='biggest == 9', show='biggest', expect='9',
    answer='nums = [4, 9, 2]\nbig = 0\nfor x in nums:\n    if x > big:\n        big = x\nbiggest = max(nums)',
    hint='max를 변수 이름으로 써서 max() 함수를 덮어썼어요.')
add(id='f3', cat=C, q='1부터 10까지(10 포함) 더해야 하는데 답이 45가 나와요. 고쳐요.',
    starter='total = 0\nfor i in range(1, 10):\n    total += i',
    check='total == 55', show='total', expect='55',
    answer='total = 0\nfor i in range(1, 11):\n    total += i', hint='range의 끝 숫자는 안 들어가요.')
add(id='f4', cat=C, q='"abc"를 읽었는데 length가 4로 나와요. 고쳐요.', stdin='abc\n',
    starter='import sys\ninput = sys.stdin.readline\ns = input()\nlength = len(s)',
    check='length == 3', show='length', expect='3',
    answer='import sys\ninput = sys.stdin.readline\ns = input().strip()\nlength = len(s)', hint='readline은 \\n을 남겨요.')
add(id='f5', cat=C, q='위쪽 칸 값을 up에 담는데, 격자 밖이면 None이어야 해요. 지금은 맨 아랫줄 값이 들어가요. 고쳐요.',
    setup='grid = [[1, 2],\n        [3, 4]]\nr, c = 0, 0',
    starter='up = grid[r - 1][c]',
    check='up is None', show='up', expect='None',
    answer='if 0 <= r - 1 < len(grid):\n    up = grid[r - 1][c]\nelse:\n    up = None',
    hint='파이썬은 grid[-1]이 에러 없이 마지막 줄이에요. 범위 검사를 먼저.')
add(id='f6', cat=C, q='arr 자체가 정렬돼야 하는데 그대로예요. 고쳐요.',
    starter='arr = [3, 1, 2]\nsorted(arr)',
    check='arr == [1, 2, 3]', show='arr', expect='[1, 2, 3]',
    answer='arr = [3, 1, 2]\narr.sort()', hint='sorted()는 새 리스트를 돌려줄 뿐이에요.')
add(id='f7', cat=C, q='n이 0이면 0번 항이 나와야 하는데 마지막 항이 나와요. 고쳐요.',
    setup='a = [1, 1, 2, 1, 1, 2, 2, 4, 4]\nn = 0',
    starter='val = a[n - 1]',
    check='val == 1 and n == 0', show='val', expect='1 (a[0])',
    answer='val = a[n]', hint='0번 항부터 시작하는 수열이에요. a[-1]은 마지막 항.')
