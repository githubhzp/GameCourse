package thunder;
import java.awt.*;
import java.awt.image.ImageObserver;
import javax.swing.JPanel;

public class Enemy {
	/**敌机的状态**/
	public static final int ENEMY_ALIVE_STATE=0;
	public static final int ENEMY_DEATH_STATE=1;
	
	/**敌机行走y轴的速度**/
	static final int ENEMY_STEP_Y=5;
	
	/**低级的(x,y)坐标**/
	public int m_posX=0;
	public int m_posY=0;
	public int mAnimState=ENEMY_ALIVE_STATE;
	private Image enemyExplorePic[]=new Image[6];  //敌机爆炸图片组合
	
	/**当前帧的ID**/
	public int mPlayID=0;
	
	public Enemy(){
		for(int i=0;i<6;i++)
			enemyExplorePic[i]=Toolkit.getDefaultToolkit().getImage("image\\bomb_enemy_"+i+".png");
	}
	
	/*初始化坐标*/
	public void init(int x,int y){
		m_posX=x;
		m_posY=y;
		mAnimState=ENEMY_ALIVE_STATE;
		mPlayID=0;
	}
	
	/*绘制敌机*/
	public void DrawEnemy(Graphics g,JPanel i){
		//当敌机状态为死亡且死亡动画播放完毕，则不再绘制敌机
		if(mAnimState==ENEMY_DEATH_STATE && mPlayID<6){
			g.drawImage(enemyExplorePic[mPlayID],m_posX,m_posY,(ImageObserver)i);
			mPlayID++;
		}
		//当敌机状态为存活状态
		Image pic=Toolkit.getDefaultToolkit().getImage("image\\el_0.png");
		g.drawImage(pic, m_posX, m_posY,(ImageObserver)i);
	}
	
	/*更新敌机坐标*/
	public void UpdateEnemy(){
		m_posY=m_posY+ENEMY_STEP_Y;
	}
}






