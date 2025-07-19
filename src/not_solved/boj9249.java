package not_solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;


public class boj9249 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String A = br.readLine();
        String B = br.readLine();
        String C = br.readLine();

        int lenA = A.length();
        // 1. 두 문자열을 특수문자로 합쳐서 하나의 문자열 S를 생성
        String S = A + "#" + B;
        int n = S.length();

        // 2. S에 대한 접미사 배열(SA) 구축
        Integer[] sa = buildSuffixArray(S);

        // 3. SA를 바탕으로 LCP 배열 구축
        int[] lcp = buildLCPArray(S, sa);

        int maxLength = 0;
        int maxIndex = -1;

        // 4. LCP 배열을 순회하며, A와 B에서 유래한 접미사 쌍의 LCP 값 중 최댓값을 찾음
        for (int i = 1; i < n; i++) {
            // 인접한 두 접미사가 각각 다른 원본 문자열(A, B)에서 왔는지 확인
            // sa[i-1]과 sa[i]는 접미사의 시작 위치(인덱스)를 담고 있음
            boolean prevIsFromA = sa[i - 1] < lenA;
            boolean currIsFromA = sa[i] < lenA;

            // 두 접미사의 출처가 다른 경우 (하나는 A, 하나는 B)
            if (prevIsFromA != currIsFromA) {
                if (lcp[i] > maxLength) {
                    maxLength = lcp[i];
                    maxIndex = sa[i]; // 어떤 접미사에서 시작했는지 위치 저장
                }
            }
        }

        // 5. 결과 출력
        System.out.println(maxLength);
        if (maxLength > 0) {
            // maxIndex에서 maxLength만큼 자른 문자열을 출력
            System.out.println(S.substring(maxIndex, maxIndex + maxLength));
        }
    }


    private static Integer[] buildSuffixArray(String text) {
        int n = text.length();
        Integer[] sa = new Integer[n]; // 접미사의 시작 인덱스를 담을 배열
        int[] group = new int[n];      // 각 접미사의 그룹(순위) 번호

        for (int i = 0; i < n; i++) {
            sa[i] = i;
            group[i] = text.charAt(i); // 초기 그룹은 첫 문자의 아스키 코드
        }

        // 비교 단위를 1, 2, 4, 8... 로 2배씩 늘려가며 정렬 반복
        for (int t = 1; t < n; t *= 2) {
            // 람다 표현식이 final이 아닌 변수(t, group)를 참조하기 위해
            // final 변수에 복사하는 표준적인 기법입니다.
            final int currentT = t;
            final int[] currentGroup = group;

            Comparator<Integer> comparator = (i, j) -> {
                // 1차 기준: 현재 그룹(t 길이 접두사) 비교
                if (currentGroup[i] != currentGroup[j]) {
                    return currentGroup[i] - currentGroup[j];
                }
                // 2차 기준: t만큼 뒤의 그룹(다음 t 길이 접두사) 비교
                int val1 = (i + currentT < n) ? currentGroup[i + currentT] : -1;
                int val2 = (j + currentT < n) ? currentGroup[j + currentT] : -1;
                return val1 - val2;
            };

            Arrays.sort(sa, comparator);

            // 새로운 그룹(순위)을 부여
            int[] newGroup = new int[n];
            newGroup[sa[0]] = 0;
            for (int i = 1; i < n; i++) {
                if (comparator.compare(sa[i - 1], sa[i]) < 0) {
                    newGroup[sa[i]] = newGroup[sa[i - 1]] + 1;
                } else {
                    newGroup[sa[i]] = newGroup[sa[i - 1]];
                }
            }
            group = newGroup; // 그룹 정보 업데이트
        }
        return sa;
    }

    /**
     * LCP 배열을 구축하는 메소드. (인접한 접미사 간의 최장 공통 접두사 길이)
     * Kasai's Algorithm을 사용하여 O(N)에 구축합니다.
     */
    private static int[] buildLCPArray(String text, Integer[] sa) {
        int n = text.length();
        int[] lcp = new int[n];
        int[] rank = new int[n]; // rank[i] = i번째 문자로 시작하는 접미사의 SA 순위
        for (int i = 0; i < n; i++) {
            rank[sa[i]] = i;
        }

        int k = 0; // 이전에 계산된 LCP 값을 재활용하여 시간을 줄임
        for (int i = 0; i < n; i++) {
            if (rank[i] == n - 1) { // 마지막 순위의 접미사는 비교 대상이 없음
                k = 0;
                continue;
            }

            int j = sa[rank[i] + 1]; // SA에서 현재 접미사의 바로 다음 순위 접미사

            // 일치하는 문자의 개수를 센다
            while (i + k < n && j + k < n && text.charAt(i + k) == text.charAt(j + k)) {
                k++;
            }

            lcp[rank[i] + 1] = k; // LCP 값을 저장

            // LCP-theorem에 따라 다음 LCP 값은 현재 LCP-1 이상이므로 k를 1만 줄여서 재활용
            if (k > 0) {
                k--;
            }
        }
        return lcp;
    }
}