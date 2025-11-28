package TrafficPack;

public class TrafficLightSimulation {
    enum TrafficLight {
        GREEN("진행", 20), YELLOW("주의", 5), RED("정지", 30);

        private String mean;
        private int duration;

        TrafficLight(String mean, int duration) {
            this.mean = mean;
            this.duration = duration;
        }
        TrafficLight nextLight() {
            switch (this) {
                case RED : {
                    return GREEN;
                }
                case YELLOW : {
                    return RED;
                }
                case GREEN : {
                    return YELLOW;
                }
                default : {
                    return this;
                }
            }
        }
    }

    public static void main(String[] args) {
        TrafficLight current = TrafficLight.RED;
        for (int i = 0; i < 5; i++) {
            System.out.println("현재 신호 : " + current);
            System.out.println("의미 : " + current.mean);
            System.out.println("신호 유지 시간 : " + current.duration);
            System.out.println();
            current = current.nextLight();
        }
    }
}