public class MonsterBattle {
    void checkZukan(MonsterZoo pz, Egg egg){
        int monsterId = (int)(pz.monsterZukan.length * Math.random());//monsterZukanからランダムにモンスターを出す
        System.out.println(pz.monsterZukan[monsterId]+"が現れた！");
        
        for(int i=0; i<3 && pz.balls>0; i++){//捕まえる or 3回ボールを投げるまで繰り返す
            int randomNum = (int)(6*Math.random());//0~5までの数字をランダムに返す
            
            //フルーツを投げる
            if(egg.fruits>0){
                System.out.println("フルーツを投げた！捕まえやすさが倍になる！");
                egg.fruits--;
                randomNum = randomNum * 2;
            }
            if(this.caputureMonster(pz, monsterId, randomNum)) break;
        }
    }


    public Boolean caputureMonster(MonsterZoo pz, int monsterId, int randomNum){
        //ボールを投げる
        System.out.println(pz.monsterZukan[monsterId]+"にボールを投げた");
        pz.balls--;
        
        //モンスターを捕まえる
        if(pz.monsterRare[monsterId] <= randomNum){//monsterRare[m]の値がr以下の場合
            System.out.println(pz.monsterZukan[monsterId]+"を捕まえた！");
            for(int j=0;j<pz.userMonster.length;j++){
                if(pz.userMonster[j]==null){
                    pz.userMonster[j]=pz.monsterZukan[monsterId];
                    break;
                }
            }
            return true; //ボール投げ終了
        }else{
            System.out.println(pz.monsterZukan[monsterId]+"に逃げられた！");
            return false;
        }
    }
}

