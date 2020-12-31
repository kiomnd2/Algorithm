public class 스킬트리 {
    public static void main(String[] args) {
        System.out.println(solution("CBD", new String[]{"BACDE", "CBADF", "AECB", "BDA"}));
        System.out.println(solution("C", new String[]{"C"}));
        System.out.println(solution("CB", new String[]{"CAAAAAAAAAABAAAAAAAAA"}));
        System.out.println(solution("ABC", new String[]{"OPQ"}));


    }

    public static int solution(String skill, String[] skill_trees) {
        int answer = 0;



        for (int i=0 ; i<skill_trees.length ; i++) {
            if(checkTree(skill, skill_trees[i])){
                answer++;
            }

        }
        return answer;
    }

    public static boolean checkTree(String skill, String skill_tree) {

        char[] s = skill.toCharArray();
        int[] visitedSkill = new int[s.length];

        // 처음값을 넣어야한다 처음 값이 있으면..
        if (skill_tree.indexOf(s[0]) != -1) {
            visitedSkill[0] = skill_tree.indexOf(s[0]);
        }
        else {
            visitedSkill[0] =  999999;
        }

        for (int i=1 ; i< s.length; i++) {
            if(visitedSkill[i-1] < skill_tree.indexOf(s[i])) {
                visitedSkill[i] = skill_tree.indexOf(s[i]);
            }
            else if (skill_tree.indexOf(s[i]) == -1) {
                visitedSkill[i] = 999999;
            }
            else {
                return false;
            }
        }
        return true;
    }
}
