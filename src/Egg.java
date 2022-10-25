


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
                int m = (int)(pz.monsterZukan.length*Math.random());
                System.out.println(pz.monsterZukan[m]+"が産まれた！");
                
                //Monsterクラスから引用したい
                for(int j=0;j<pz.userMonster.length;j++){
                    if(pz.userMonster[j]==null){
                        pz.userMonster[j]=pz.monsterZukan[m];
                        break;
                    }
                }
                this.checkCount[i]=false;
                this.distance[i]=0.0;
            }
        }
    }
    
}