

public class Egg {
    double distance[] = new double[9];
	boolean checkCount[] = new boolean[9];

    void updateEggDistance(){
        for(int i=0;i<this.checkCount.length;i++){//卵は移動距離が進むと孵化するため，何km移動したかを更新する
			if(this.checkCount[i]==true){
				this.distance[i]++;
			}
		}
    }

    void setEggs(){
        for(int i=0; i<this.distance.length; ++i){
            if(this.checkCount[i]==false){
                this.checkCount[i]=true;
                this.distance[i]=0.0;
                break;
            }
        }
    }

    void checkHatch(MonsterZoo pz){
        for(int i=0;i<this.checkCount.length;i++){
            if(this.checkCount[i]==true&&this.distance[i]>=3){
                System.out.println("卵が孵った！");
                int monsterId = (int)(pz.monsterZukan.length*Math.random());
                System.out.println(pz.monsterZukan[monsterId]+"が産まれた！");

                //Monsterクラスから引用したい
                pz.setUserMonster(monsterId);
                this.checkCount[i]=false;
                this.distance[i]=0.0;
            }
        }
    }

}