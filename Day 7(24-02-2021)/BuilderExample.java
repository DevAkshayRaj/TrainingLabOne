package day7_Concepts;

public class BuilderExample {
	public static void main(String[] args) {
		SoundSystem s1=new SoundSystem.SoundSystemBuilder().init("Can Play Sounds", "upto 100" , "Available", "Available").setRearSpeakers("Rear Left and Rear Right").setRemote("Available").getObj();
		SoundSystem s2=new SoundSystem.SoundSystemBuilder().init("Can Play Sounds", "upto 50" , "Not Available", "Not Available").getObj();
		System.out.println(s1);
		System.out.println(s2);
	}
}

class SoundSystem{
	private String sound;
	private String volumecontrol;
	private String toggleState;
	private String trackchange;
	
	private String rearSpeakers;
	private String surroundspeakers;
	private String remote;
	
	SoundSystem(SoundSystemBuilder b){
		this.sound=b.sound;
		this.volumecontrol=b.volumecontrol;
		this.toggleState=b.toggleState;
		this.trackchange=b.trackchange;
		this.rearSpeakers=b.rearSpeakers;
		this.surroundspeakers=b.surroundspeakers;
		this.remote=b.remote;
	}
	
	public final String getSound() {
		return sound;
	}
	public final void setSound(String sound) {
		this.sound = sound;
	}
	public final String getVolumecontrol() {
		return volumecontrol;
	}
	public final void setVolumecontrol(String volumecontrol) {
		this.volumecontrol = volumecontrol;
	}
	public final String getToggleState() {
		return toggleState;
	}
	public final void setToggleState(String toggleState) {
		this.toggleState = toggleState;
	}
	public final String getTrackchange() {
		return trackchange;
	}
	public final void setTrackchange(String trackchange) {
		this.trackchange = trackchange;
	}
	public final String getRearSpeakers() {
		return rearSpeakers;
	}
	public final void setRearSpeakers(String rearSpeakers) {
		this.rearSpeakers = rearSpeakers;
	}
	public final String getSurroundspeakers() {
		return surroundspeakers;
	}
	public final void setSurroundspeakers(String surroundspeakers) {
		this.surroundspeakers = surroundspeakers;
	}
	public final String getRemote() {
		return remote;
	}
	public final void setRemote(String remote) {
		this.remote = remote;
	}
	@Override
	public String toString() {
		return "SoundSystem [sound=" + sound + ", volumecontrol=" + volumecontrol + ", toggleState=" + toggleState
				+ ", trackchange=" + trackchange + ", rearSpeakers=" + rearSpeakers + ", surroundspeakers="
				+ surroundspeakers + ", remote=" + remote + "]";
	}
	
	static class SoundSystemBuilder{
		private String sound;
		private String volumecontrol;
		private String toggleState;
		private String trackchange;

		private String rearSpeakers;
		private String surroundspeakers;
		private String remote;
		
		public SoundSystemBuilder init(String s,String volume,String t,String c) {
			sound=s;
			volumecontrol=volume;
			toggleState=t;
			trackchange=c;
			return this;
		}
		
		public final SoundSystemBuilder setSurroundspeakers(String ts) {
			surroundspeakers=ts;
			return this;
		}

		public final SoundSystemBuilder setRearSpeakers(String rearSpeakers) {
			this.rearSpeakers = rearSpeakers;
			return this;
		}

		public final SoundSystemBuilder setRemote(String remote) {
			this.remote = remote;
			return this;
		}
		
		public SoundSystem getObj() {
			return new SoundSystem(this);
		}
		
	}
}