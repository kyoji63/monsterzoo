import java.util.ArrayList;
import java.util.List;


public class Egg {
    List<Double> distance = new ArrayList<Double>(9);
    List<Boolean> checkCount = new ArrayList<Boolean>(9);
    void updateEggDistance(){
        BooleanList.stream()
                .filter(i -> i < this.checkCount.length)
                .filter(i -> this.checkCount.get(i) == true)
                .forEach(i -> this.distance.get(i)++);
    }

    void setEggs(){
        for(int i=0; i<this.distance.length; ++i){
            if(this.checkCount.get(i)==false){
                this.checkCount.get(i)=true;
                this.distance.get(i)=0.0;
                break;
            }
        }
    }

    void setUserMonster(MonsterZoo pz, int m){
        for(int j=0;j<pz.userMonster.length;j++){
            if(pz.userMonster[j]==null){
                pz.userMonster[j]=pz.monsterZukan[m];
                break;
            }
        }
    }

    void checkHatch(MonsterZoo pz){
        BooleanList.stream()
                .filter(i -> i < this.checkCount.length)
                .filter(i -> this.checkCount.get(i) == true && this.distance.get(i) >= 3)
                .forEach(i -> {
                    System.out.println("卵が孵った！");
                    int m = (int)(pz.monsterZukan.length*Math.random());
                    System.out.println(pz.monsterZukan[m]+"が産まれた！");
                    setUserMonster(pz, m);
                    this.checkCount.get(i) = false; 
                    this.distance.get(i) = 0.0;
                });
    }
}