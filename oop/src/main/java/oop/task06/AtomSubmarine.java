package oop.task06;


import lombok.Getter;
import oop.task07.MyAnno;

@SuppressWarnings("WeakerAccess")
@MyAnno(module = "oopModule", task = 6)
public class AtomSubmarine {
    public class Engine{

        @Getter
        private boolean running;

        private Engine(){}

        private void run(){
            running = true;
        }

        private void stop(){
            running = false;
        }
    }

    public final Engine engine;

    public AtomSubmarine(){
        engine = new Engine();
    }

    @Getter
    private int speed;
    public void go(int speed){
        engine.run();
        this.speed = speed;
    }

    public void stop(){
        this.speed = 0;
    }

    public void shutdown(){
        stop();
        engine.stop();
    }

}
