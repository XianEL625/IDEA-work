import com.gzu.nomodel.MallarDuck;
import com.gzu.strategy.fly.FlyWithWings;
import com.gzu.strategy.fly.IFlyBehavior;
import com.gzu.strategy.speak.ISpeakBehavior;
import com.gzu.strategy.speak.Quack;
import com.gzu.strategy.speak.Squeak;

public class MyTest {
    @Test
    public void textFun1(){
        ISpeakBehavior speakBehavior=new Quack();
        IFlyBehavior flyBehavior=new FlyWithWings();
        MallarDuck mallarDuck=new MallarDuck(flyBehavior,speakBehavior);
        mallarDuck.fly();
        mallarDuck.speak();
        speakBehavior=new Squeak();
        mallarDuck.setSpeakBehavior(speakBehavior);
        mallarDuck.fly();
    }
}
