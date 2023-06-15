package states;

import java.awt.Color;
import java.awt.Graphics;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

import gameObjects.Constants;
import graphics.Assets;
import graphics.Text;
import io.JSONParser;
import io.ScoreData;
import math.Vector2D;
import ui.Action;
import ui.Button;

public class ScoreState extends State{
	
	private final Button returnButton;
	
	private final PriorityQueue<ScoreData> highScores;
	
	private final Comparator<ScoreData> scoreComparator;

	public ScoreState() {
		returnButton = new Button(
				Assets.greyBtn,
				Assets.blueBtn,
				Assets.greyBtn.getHeight(),
				Constants.HEIGHT - Assets.greyBtn.getHeight() * 2,
				Constants.RETURN,
				() -> State.changeState(new MenuState())
		);
		
		scoreComparator = (e1, e2) -> e1.getScore() < e2.getScore() ? -1 : e1.getScore() > e2.getScore() ? 1 : 0;
		
		highScores = new PriorityQueue<>(10, scoreComparator);
		
		try {
			ArrayList<ScoreData> dataList = JSONParser.readFile();

			highScores.addAll(dataList);
			
			while(highScores.size() > 10) {
				highScores.poll();
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void update(float dt) {
		returnButton.update();
	}

	@Override
	public void draw(Graphics g) {
		returnButton.draw(g);

		ScoreData[] auxArray = highScores.toArray(new ScoreData[0]);
		
		Arrays.sort(auxArray, scoreComparator);
		
		
		Vector2D scorePos = new Vector2D(
				(double) Constants.WIDTH / 2 - 200,
				100
				);
		Vector2D datePos = new Vector2D(
				(double) Constants.WIDTH / 2 + 200,
				100
				);
		
		Text.drawText(g, Constants.SCORE, scorePos, true, Color.BLUE, Assets.fontBig);
		Text.drawText(g, Constants.DATE, datePos, true, Color.BLUE, Assets.fontBig);
		
		scorePos.setY(scorePos.getY() + 40);
		datePos.setY(datePos.getY() + 40);
		
		for(int i = auxArray.length - 1; i > -1; i--) {
			
			ScoreData d = auxArray[i];
			
			Text.drawText(g, Integer.toString(d.getScore()), scorePos, true, Color.WHITE, Assets.fontMed);
			Text.drawText(g, d.getDate(), datePos, true, Color.WHITE, Assets.fontMed);
			
			scorePos.setY(scorePos.getY() + 40);
			datePos.setY(datePos.getY() + 40);
			
		}
		
	}
	
}
