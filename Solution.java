//Level 1 신고결과 받기
class Solution {
    public static int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        //신고된 횟수
        int[] count = new int[id_list.length];
        boolean tf = false;

        //신고한 유저
        String[] user = new String[id_list.length];

        for (int i = 0; i < report.length; i++){
            String[] re = report[i].split(" ");    //report 구분

            for (int j = 0; j < id_list.length; j++) {

                tf = false;
                if (id_list[j].equals(re[0])){          //신고자 탐색
                    //첫 신고일때
                    if (user[j] == null){
                        user[j] = re[1];        //신고한 유저 추가
                    }

                    //중복 제거
                    else {
                        String ed[] = user[j].split(" ");   //신고내역 구분

                        //신고내역 검색
                        for (int m = 0; m < ed.length; m++)
                            if (ed[m].equals(re[1])) {
                                tf = true;
                                break;
                            }
                        //중복되지 않았다면 신고 접수
                        if (!tf)
                            user[j] = user[j] + " " + re[1];
                    }
                }
            }
        }

        //신고종합
        for (int i = 0; i < user.length; i++) {
            //신고한적이 없다면 패스
            if (user[i] != null) {
                String[] temp = user[i].split(" ");
                for (int j = 0; j < id_list.length; j++) {
                    for (int m = 0; m < temp.length; m++) {
                        if (id_list[j].equals(temp[m])) {
                            count[j]++;
                        }
                    }
                }
            }
        }
        //정지 시키기
        for (int i = 0; i< id_list.length; i++) {
            if (count[i] >= k) {
                //정지되는 이용자를 신고한 이용자
                for (int j = 0; j < user.length; j++) {
                    if(user[j] != null) {
                        String[] temp = user[j].split(" ");
                        for (int m = 0; m < temp.length; m++) {
                            if (id_list[i].equals(temp[m])) {
                                answer[j]++;
                            }
                        }
                    }
                }
            }
        }
        return answer;
    }
}
