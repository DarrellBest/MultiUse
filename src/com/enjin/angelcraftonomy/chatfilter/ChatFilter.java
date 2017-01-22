package com.enjin.angelcraftonomy.chatfilter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class ChatFilter {

	private ArrayList<String> profanity;
	private ArrayList<String> replacements;

	public ChatFilter() {
		profanity = new ArrayList<String>();
		replacements = new ArrayList<String>();
		String[] candies = { "frick", "fraggle", "frazzle", "fragdaggle",
				"bum", "bummer", "dang", "blangdang", "bleep", "blast", "bite",
				"chafed", "gargle", "chap", "crud", "crabcakes",
				"Donald Trump", "crabcake", "dipstick", "dag nabit", "drat",
				"farging", "fudge", "flip", "gravy", "gadzooks",
				"gee willikers", "hockey puck", "hogwart", "jimmy dean",
				"sausage", "fluff", "huff", "piddle", "frazzin", "shat",
				"stuff", "snap", "shamalama", "skittle" };
		String[] words = { "4r5e", "5h1t", "boob", "5hit", "a55", "anal",
				"anus", "ar5e", "arrse", "arse", "ass ", "ass-fucker", "asses",
				"assfucker", "assfukka", "asshole", "assholes", "asswhole",
				"a_s_s", "b!tch", "b00bs", "b17ch", "b1tch", "ballbag",
				"ballsack", "bastard", "beastial", "beastiality", "bellend",
				"bestial", "bestiality", "bi+ch", "biatch", "bitch", "bitcher",
				"bitchers", "bitches", "bitchin", "bitching", "bloody",
				"blow job", "blowjob", "blowjobs", "boiolas", "bollock",
				"bollok", "boner", "boob", "boobs", "booobs", "boooobs",
				"booooobs", "booooooobs", "breasts", "buceta", "bugger",
				"bunny fucker", "butthole", "buttmuch", "buttplug", "c0ck",
				"carpet muncher", "cawk", "chink", "cipa", "cl1t", "clit",
				"cnut", "cock", "cok", "kok", "coon", "cox", "crap", "cum",
				"cunilingus", "cunillingus", "cunnilingus", "cunt", "cyalis",
				"d1ck", "damn", "dick", "dickhead", "dildo", "dildos", "dink",
				"dinks", "dirsa", "dlck", "dog-fucker", "doggin", "dogging",
				"donkeyribber", "doosh", "duche", "dyke", "ejaculate",
				"ejaculated", "ejaculates", "ejaculating", "ejaculatings",
				"ejaculation", "ejakulate", "fuck", "fuxk", "f u c k",
				"f u c k e r", "f4nny", "fag", "fagging", "faggitt", "faggot",
				"faggs", "fagot", "fagots", "fags", "fanny", "fannyflaps",
				"fannyfucker", "fanyy", "fatass", "fcuk", "fcuker", "fcuking",
				"feck", "fecker", "felching", "fellate", "fellatio",
				"fingerfuck", "fingerfucked", "fingerfucker", "fingerfuckers",
				"fingerfucking", "fingerfucks", "fistfuck", "fistfucked",
				"fistfucker", "fistfuckers", "fistfucking", "fistfuckings",
				"fistfucks", "flange", "fook", "fooker", "fuck", "fucka",
				"fucked", "fucker", "fuckers", "fuckhead", "fuckheads",
				"fuckin", "fucking", "fuckings", "fuckingshitmotherfucker",
				"fuckme", "fucks", "fuckwhit", "fuckwit", "fudge packer",
				"fudgepacker", "fuk", "fuker", "fukker", "fukkin", "fuks",
				"fukwhit", "fukwit", "fux", "fux0r", "f_u_c_k", "gangbang",
				"gangbanged", "gangbangs", "gaylord", "gaysex", "goatse",
				"God", "god-dam", "god-damned", "goddamn", "goddamned",
				"hardcoresex", "heshe", "hoar", "hoare", "hoer", "homo",
				"hore", "horniest", "horny", "hotsex", "jack-off", "jackoff",
				"jap", "jerk-off", "jism", "jiz", "jizm", "jizz", "kawk",
				"knob", "knobead", "knobed", "knobend", "knobhead",
				"knobjocky", "knobjokey", "kock", "kondum", "kondums", "kum",
				"kummer", "kumming", "kums", "kunilingus", "l3i+ch", "l3itch",
				"labia", "lmfao", "lust", "lusting", "m0f0", "m0fo",
				"m45terbate", "ma5terb8", "ma5terbate", "masochist",
				"master-bate", "masterb8", "masterbat*", "masterbat3",
				"masterbate", "masterbation", "masterbations", "masturbate",
				"mo-fo", "mof0", "mofo", "mothafuck", "mothafucka",
				"mothafuckas", "mothafuckaz", "mothafucked", "mothafucker",
				"mothafuckers", "mothafuckin", "mothafucking", "mothafuckings",
				"mothafucks", "mother fucker", "motherfuck", "motherfucked",
				"motherfucker", "motherfuckers", "motherfuckin",
				"motherfucking", "motherfuckings", "motherfuckka",
				"motherfucks", "muff", "mutha", "muthafecker", "muthafuckker",
				"muther", "mutherfucker", "n1gga", "n1gger", "nazi", "nigg3r",
				"nigg4h", "nigga", "niggah", "niggas", "niggaz", "nigger",
				"niggers", "nob", "nob jokey", "nobhead", "nobjocky",
				"nobjokey", "numbnuts", "nutsack", "orgasim", "orgasims",
				"orgasm", "orgasms", "p0rn", "pecker", "penis", "penisfucker",
				"phonesex", "phuck", "phuk", "phuked", "phuking", "phukked",
				"phukking", "phuks", "phuq", "pigfucker", "pimpis", "piss",
				"pissed", "pisser", "pissers", "pisses", "pissflaps", "pissin",
				"pissing", "pissoff", "porn", "porno", "pornography", "pornos",
				"prick", "pricks", "pron", "pube", "pusse", "pussi", "pussies",
				"pussy", "pussys", "rectum", "retard", "rimjaw", "rimming",
				"s hit", "s.o.b.", "sadist", "schlong", "screwing", "scroat",
				"scrote", "scrotum", "semen", "sex", "sh!+", "sh!t", "sh1t",
				"shag", "shagger", "shaggin", "shagging", "shemale", "shi+",
				"shit", "shitdick", "shite", "shited", "shitey", "shitfuck",
				"shitfull", "shithead", "shiting", "shitings", "shits",
				"shitted", "shitter", "shitters ", "shitting", "shittings",
				"shitty ", "skank", "slut", "sluts", "smegma", "smut",
				"snatch", "son-of-a-bitch", "spac", "spunk", "s_h_i_t",
				"t1tt1e5", "t1tties", "teets", "teez", "testical", "testicle",
				"tit", "titfuck", "tits", "titt", "tittie5", "tittiefucker",
				"titties", "tittyfuck", "tittywank", "titwank", "tosser",
				"turd", "tw4t", "twat", "twathead", "twatty", "twunt",
				"twunter", "v14gra", "v1gra", "vagina", "viagra", "vulva",
				"w00se", "wang", "wank", "wanker", "wanky", "whoar", "whore",
				"willies", "willy", "xrated", "xxx" };

		profanity.addAll(Arrays.asList(words));
		replacements.addAll(Arrays.asList(candies));
	}

	public String replaceSwearWords(String message) {
		String retVal = message;
		Random rand = new Random();
		int temp;

		for (String curse : profanity)
			if (message.toLowerCase().contains(curse)) {
				temp = rand.nextInt(replacements.size());
				message = message.toLowerCase().replaceAll(curse,
						replacements.get(temp));
			}

		retVal = message;
		return retVal;
	}

	public String upperCase(String message) {
		String retVal = message;
		retVal = retVal.substring(0, 1).toUpperCase() + retVal.substring(1);
		return retVal;
	}

	public String removeSymbols(String message) {
		String retVal = message;
		retVal = retVal.replaceAll("[", "").replaceAll("]", "");
		retVal = retVal.replaceAll("{", "").replaceAll("}", "");
		return retVal;
	}

}
