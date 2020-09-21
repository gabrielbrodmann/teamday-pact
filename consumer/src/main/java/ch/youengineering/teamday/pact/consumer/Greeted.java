package ch.youengineering.teamday.pact.consumer;

public class Greeted {
    private String greeted;

    public String getGreeted() {
        return greeted;
    }

    public void setGreeted(String greeted) {
        this.greeted = greeted;
    }

    public static final class GreetedBuilder {
        private String greeted;

        private GreetedBuilder() {
        }

        public static GreetedBuilder aGreeted() {
            return new GreetedBuilder();
        }

        public GreetedBuilder greeted(String greeted) {
            this.greeted = greeted;
            return this;
        }

        public Greeted build() {
            Greeted greeted = new Greeted();
            greeted.greeted = this.greeted;
            return greeted;
        }
    }
}
