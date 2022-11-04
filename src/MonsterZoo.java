

public class MonsterZoo {
	static Egg egg = new Egg(); 
	static MonsterBattle battle = new MonsterBattle();
	double distance=0.0;//歩いた距離
	int balls=10;//モンスターを捕まえられるボールの数
	int fruits=0;//ぶつけるとモンスターが捕まえやすくなるフルーツ

	//卵は最大9個まで持てる．卵を取得するとeggにtrueが代入され，
	//移動するたびに,eggDistanceに1.0kmずつ加算される．
	//3km移動するとランダムでモンスターが孵る
	
	//ユーザがGetしたモンスター一覧
	String userMonster[] = new String[100];

	//モンスター図鑑．モンスターの名前とレア度(0.0~9.0)がそれぞれの配列に保存されている
	//レア度が高いほうが捕まえにくい
	String monsterZukan[] = new String[22];
	double monsterRare[] = new double[22];

	//呼び出すと1km distanceが増える
	void move(){
		this.distance++;
		egg.updateEggDistance();

		int flg1 = (int)(Math.random()*10);//0,1の場合はズーstation，7~9の場合はモンスター
		if(flg1<=1){
			System.out.println("ズーstationを見つけた！");
			int b=(int)(Math.random()*3);//ball,fruits,eggがランダムに出る
			int f=(int)(Math.random()*2);
			int e=(int)(Math.random()*2);
			System.out.println("ボールを"+b+"個，"+"フルーツを"+f+"個"+"卵を"+e+"個Getした！");
			this.balls=this.balls+b;
			this.fruits=this.fruits+f;
			if(e>=1){
				egg.setEggs();
			}
		}else if(flg1>=7){
			battle.checkZukan(this);
		}

		egg.checkHatch(this);
	}
	void setUserMonster(int monsterId){
        for(int j=0;j<this.userMonster.length;j++){
            if(this.userMonster[j]==null){
                this.userMonster[j]=this.monsterZukan[monsterId];
                break;
            }
        }
    }
}
