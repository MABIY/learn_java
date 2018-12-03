package typeinfo;

import static access.util.Print.print;

/**
 * @author: liuHua
 * @create: 2018-12-03 16:00
 * Implement clearSpitValve() as described in the summary.
 * The summary reads:
 * one option is to put a clearSpitValve() method in
 * the base class instrument, but this is confusing and
 * Electronic instruments also have spit valves.RTTI
 * provides a mush more reasonable solution because you
 * can place the medhod in the specific class where it's
 * appropriate (Wind, in this case).At the some time,
 * you may discover that there's a more sensible solution-here.
 * a prepareInstrument() method in the base class. However , you might not seee
 * such as solugion when you're first solving the problem and could
 * mistakenly assume that you must use RTTI
 **/

interface Instrument {
	void play();
	
	String what();
	
	void adjust();
	
	void prepareInstrument();
}


class Wind implements Instrument {
	@Override
	public void play() {
		print("Wind.play()");
	}
	
	@Override
	public String what() {
		return "Wind";
	}
	
	@Override
	public void adjust() {
	}
	
	
	public void clearSpitValve() {
		print("Wind.clearSpitValve");
	}
	@Override
	public void prepareInstrument() {
		clearSpitValve();
	}
}

class Percussion implements Instrument {
	@Override
	public void play() {
		print("Percussion.play()");
	}
	
	@Override
	public String what() {
		return "Percussion";
	}
	
	@Override
	public void adjust() {
	
	}
	
	@Override
	public void prepareInstrument() {
		print("Percussion.prepareInstrument");
	}
}

class Stringed implements Instrument {
	@Override
	public void play() {
		print("Stringed.play()");
	}
	
	@Override
	public String what() {
		return "Stringed";
	}
	
	@Override
	public void adjust() {
	
	}
	
	@Override
	public void prepareInstrument() {
		print("Stringed.prepareInstrument");
	}
}

class Brass extends Wind {
	@Override
	public void play() {
		print("Brass.play()");
	}
	
	@Override
	public void adjust() {
		print("Brass.adjust");
	}
	
	@Override
	public void clearSpitValve() {
		print("Brass.clearSpitValve");
	}
}

class Woodwind extends Wind {
	@Override
	public void play() {
		print("Woodwind.play()");
	}
	
	@Override
	public String what() {
		return "Woodwind";
	}
	
	@Override
	public void clearSpitValve() {
		print("Woodwind.clearSpitValve");
	}
}

class Music5 {
	static void tune(Instrument i) {
		// ...
		i.play();
	}
	
	static void tuneAll(Instrument[] e) {
		for (Instrument instrument : e) {
			tune(instrument);
		}
	}
	
	static void prepareAll(Instrument[] e) {
		for (Instrument instrument : e) {
			instrument.prepareInstrument();
		}
	}
}
public class E26_ClearSpitValve {
	public static void main(String[] args) {
		Instrument[] orchestra = {
				new Wind(), new Percussion(),
				new Stringed(), new Brass(),
				new Woodwind()
		};
		Music5.prepareAll(orchestra);
		Music5.tuneAll(orchestra);
	}
}
