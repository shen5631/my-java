package TrafficPack;

public class TrafficLightExam {
    enum TrafficLight {
        GREEN("진행", 20), YELLOW("주의", 5), RED("정지", 30);

        private String meaning;
        private int duration;

        TrafficLight(String meaning, int duration) {
            this.meaning = meaning;
            this.duration = duration;
        }
    }

    public static void main(String[] args) {
        for (TrafficLight light : TrafficLight.values()) {
            System.out.println(light + " 신호는 " + light.meaning + " 상태이고, " + light.duration + "초 동안 유지됩니다.");
        }
        TrafficLight current = TrafficLight.GREEN;
        switch (current) {
            case RED : {
                System.out.println(current.meaning + " 상태이므로 멈추세요.");
                break;
            }
            case YELLOW : {
                System.out.println(current.meaning + " 상태이므로 주변을 살피세요.");
                break;
            }
            case GREEN : {
                System.out.println(current.meaning + " 상태이므로 가세요.");
                break;
            }
        }
    }
}
