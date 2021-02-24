package Day7;

public class CommandDemo {
	public static void main(String args[]) {
		TV tv=new TV();
		SetupBox st=new SetupBox();
		VideoGame vg=new VideoGame();
		SoundSystem ss=new SoundSystem();
		WatchNewsChannel father=new WatchNewsChannel(tv, st, vg, ss);
		WatchNewsChannel mother=new WatchNewsChannel(tv, st, vg, ss);
		PlayVideoGame father1=new PlayVideoGame(tv, st, vg, ss);
		UniversalRemote ur=new UniversalRemote();
		ur.setCommand(0,father);
		ur.setCommand(1, mother);
		ur.setCommand(2, father1);
		ur.exec(0);
	}
}

class UniversalRemote {
	Command command[]=new Command[5];
	UniversalRemote() {	
		for(int i=0;i<5;i++) {
			command[i]=new DummyCommand();
		}
	}
	
	public void setCommand(int slot,Command c) {
		command[slot]=c;
	}
	
	public void exec(int slot) {
		command[slot].execute();
	}
	
}

abstract class Command {
	TV tv;
	SetupBox sb;
	VideoGame vg;
	SoundSystem ss;
	
	public Command() {
		
	}
	public Command(TV tv, SetupBox sb, VideoGame vg, SoundSystem ss) {
		this.tv = tv;
		this.sb = sb;
		this.vg = vg;
		this.ss = ss;
	}

	public abstract void execute();
}

class DummyCommand extends Command {
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		System.out.println("I am a Dummy Command!!");
	}
}

class WatchNewsChannel extends Command {
	public WatchNewsChannel(TV tv, SetupBox sb, VideoGame vg, SoundSystem ss) {
		super(tv, sb, vg, ss);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		System.out.println("News Channel Command Process Starts!!");
		tv.switchOn();
		tv.changeToAV();
		sb.newsChannelChange();
		System.out.println("Process Over!!");
	}
}

class WatchSerialChannel extends Command {
	public WatchSerialChannel(TV tv, SetupBox sb, VideoGame vg, SoundSystem ss) {
		super(tv, sb, vg, ss);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		System.out.println("Serial Channel Command Process Starts!!");
		tv.switchOn();
		tv.changeToAV();
		sb.serialChannelChange();
		System.out.println("Process Over!!");
	}
}

class PlayVideoGame extends Command {
	public PlayVideoGame(TV tv, SetupBox sb, VideoGame vg, SoundSystem ss) {
		super(tv, sb, vg, ss);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		System.out.println("Video Game Process Starts!!");
		tv.switchOn();
		tv.changeToAV();
		vg.playVideoGame();;
		System.out.println("Process Over!!");
	}
}

class TV {
	public void switchOn() {
		System.out.println("TV Switched ON!!!");
	}
	public void changeToAV() {
		System.out.println("AV Mode Selected!!");
	}
}

class SetupBox {
	public void newsChannelChange() {
		System.out.println("Channel Changed to News!!");
	}
	public void serialChannelChange() {
		System.out.println("Channel changed to Serial!!");
	}
}

class VideoGame {
	public void playVideoGame() {
		System.out.println("Tennis Video Game Started!!");
	}
}

class SoundSystem {
	public void soundLow() {
		System.out.println("Volume Decreased!!");
	}
	public void soundHigh() {
		System.out.println("Volume Increased!!");
	}
}
