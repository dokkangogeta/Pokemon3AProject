package start;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;


import javafx.application.Application;
import javafx.stage.Stage;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.image.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.scene.shape.*;
import javafx.scene.text.*;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;


public class Main extends Application{
	
	private Parent createContent() {
		Pane root = new Pane();
		Poke();
		root.setPrefSize(860, 600);
		
		try (InputStream is = Files.newInputStream(Paths.get("res/images/201302165586000.jpg"))) {
			ImageView img = new ImageView(new Image(is));
			img.setFitWidth(860);
			img.setFitHeight(600);
			root.getChildren().add(img);
		}
		catch (IOException e)  {
			System.out.println("Couldn't load image");
			
		}
		
		Title title = new Title("POKEMON");
		
		title.setTranslateX(75);
		title.setTranslateY(200);
		
		MenuItem itemExit = new MenuItem("QUITTER");
		itemExit.setOnMouseClicked(event -> System.exit(0));
		
		MenuItem Clik = new MenuItem("LANCER COMBAT");
		Clik.setOnMouseClicked(event -> System.exit(0));
		
		MenuBox menu = new MenuBox(
				//new MenuItem("CONTINUE [ONLINE]"),
				//new MenuItem("CONTINUE [OFLINE]"),
				//new MenuItem("NEW GAME"),
				//new MenuItem("LANCER COMBAT"),
				Clik,
				new MenuItem("LES POKEMONS"),
				//new MenuItem("JOIN CO-UP"),
				itemExit);
			menu.setTranslateX(100);
			menu.setTranslateY(300);
			
			root.getChildren().addAll(title, menu);
	
			return root;
	}
@Override
public void start(Stage primaryStage) throws Exception {
	Scene scene = new Scene(createContent());
	primaryStage.setTitle("Pokemon The Game");
	primaryStage.setScene(scene);
	primaryStage.show();
	PokeSong();
	
}

private static class Title extends StackPane {
	public Title(String name) {
		Rectangle bg = new Rectangle(250, 60);
		bg.setStroke(Color.DARKBLUE);
		bg.setStrokeWidth(2);
		bg.setFill(null);
		
		Text text = new Text(name);
		text.setFill(Color.DARKRED);
		text.setFont(Font.font("COPPER BLACK", FontWeight.BOLD, 50));
		//Tw Cen MT Condensed
		setAlignment(Pos.CENTER);
		getChildren().addAll(bg, text);
	}
}


private static class MenuBox extends VBox {
	public MenuBox(MenuItem...items) {
		getChildren().add(createSeparator());
		
		for (MenuItem item : items) {
			getChildren().addAll(item, createSeparator());
			
		}
	}
	private Line createSeparator() {
		Line sep = new Line();
		sep.setEndX(200);
		sep.setStroke(Color.DARKGREY);
		return sep;
	}
}

private static class MenuItem extends StackPane {
		public MenuItem(String name) {
			LinearGradient gradient = new LinearGradient(0, 0, 1, 0, true, CycleMethod.NO_CYCLE, new Stop[] {

					new Stop(0, Color.DARKVIOLET),
					new Stop(0.1, Color.BLACK),
					new Stop(0.9, Color.BLACK),
					new Stop(1, Color.DARKVIOLET)
			});
			
			Rectangle bg = new Rectangle(200, 30);
			bg.setOpacity(0.4);
			
			Text text = new Text(name);
			text.setFill(Color.DARKGREY);
			text.setFont(Font.font("Tw Cen MTCondensed", FontWeight.SEMI_BOLD, 22));
			
			setAlignment(Pos.CENTER);
			getChildren().addAll(bg, text);
			
			setOnMouseEntered(event -> {
				bg.setFill(gradient);
				text.setFill(Color.WHITE);
			});
					
			setOnMouseExited(event -> {
				bg.setFill(Color.BLACK);
				text.setFill(Color.DARKGREY);
			});
			setOnMousePressed(event -> {
				bg.setFill(Color.DARKVIOLET);
			});
			setOnMouseReleased(event -> {
				bg.setFill(gradient);
			});
			
					
					
			
			}

		public void setOnMouseClicked(
				EventHandler<? super MouseEvent> eventHandler,
				jFrameMain jFrameMain) {
			// TODO Auto-generated method stub
			
		}
}

private void PokeSong()
{
	try{
		InputStream inputStream = getClass().getResourceAsStream("Dubstep_Pokebattle_Point_culture.wav");
		AudioStream audiostream = new AudioStream(inputStream);
		AudioPlayer.player.start(audiostream);
		}
	catch (Exception e)
	{
		e.printStackTrace();
	}
}
private void Poke()
{
	try{
		InputStream inputStream = getClass().getResourceAsStream("Pokeball_sound_effects.wav");
		AudioStream audiostream = new AudioStream(inputStream);
		AudioPlayer.player.start(audiostream);
		}
	catch (Exception e)
	{
		e.printStackTrace();
	}
}


public static void main(String[] args) {
		launch(args);
		
	}
}
