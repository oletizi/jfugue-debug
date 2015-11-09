package org.jfugue.bugs;

import org.jfugue.pattern.Pattern;
import org.jfugue.player.Player;

//
// Problem had been that parser mistakenly tried to get a note name from "[closed_hi_hat]s+[bass_drum]s" as "closed_hi_hat]s+[bass_drum"
// Solution was to fix NoteSubparser.parseBracketedNote - in there, a substring was starting from 1 instead of index+1.
// Also while in there, I added a try/catch block around the code that looks up the note and duration from the dictionary to make
// it easier to find incorrectly-formatted note/duration names.
//
// Reported 4/21/14 by JC Reyes via email to dmkoelle
// Solved 4/21/14 by dmkoelle and reported back to JC Reyes
//

public class Bug_2014_04_21_JCReyes {
	public static void main(String[] args) {
		Pattern pattern = new Pattern("T[Andantino] V9 [closed_hi_hat]s+[bass_drum]s [closed_hi_hat]s [closed_hi_hat]s [closed_hi_hat]s [closed_hi_hat]s+[acoustic_snare]s [closed_hi_hat]s [closed_hi_hat]s [closed_hi_hat]s+[acoustic_snare]s [closed_hi_hat]s [closed_hi_hat]s+[acoustic_snare]s [closed_hi_hat]s [open_hi_hat]s+[bass_drum]s [closed_hi_hat]s+[acoustic_snare]s [closed_hi_hat]s [closed_hi_hat]s [closed_hi_hat]s [closed_hi_hat]s+[bass_drum]s [closed_hi_hat]s [closed_hi_hat]s [closed_hi_hat]s [closed_hi_hat]s+[acoustic_snare]s [closed_hi_hat]s [closed_hi_hat]s [closed_hi_hat]s+[acoustic_snare]s [closed_hi_hat]s [closed_hi_hat]s+[acoustic_snare]s [closed_hi_hat]s [open_hi_hat]s+[bass_drum]s [closed_hi_hat]s+[acoustic_snare]s [closed_hi_hat]s [closed_hi_hat]s [closed_hi_hat]s [closed_hi_hat]s+[bass_drum]s [closed_hi_hat]s [closed_hi_hat]s [closed_hi_hat]s [closed_hi_hat]s+[acoustic_snare]s [closed_hi_hat]s [closed_hi_hat]s [closed_hi_hat]s+[acoustic_snare]s [closed_hi_hat]s [closed_hi_hat]s+[acoustic_snare]s [closed_hi_hat]s [open_hi_hat]s+[bass_drum]s [closed_hi_hat]s+[acoustic_snare]s [closed_hi_hat]s [closed_hi_hat]s [closed_hi_hat]s [acoustic_snare]s [acoustic_snare]s [acoustic_snare]s [acoustic_snare]s [bass_drum]i [acoustic_snare]s [acoustic_snare]s Rs [bass_drum]s [acoustic_snare]i [bass_drum]i [acoustic_snare]s [acoustic_snare]s Rs [bass_drum]s [acoustic_snare]i [bass_drum]i [acoustic_snare]s [acoustic_snare]s Rs [bass_drum]s [acoustic_snare]i [bass_drum]i [acoustic_snare]s [acoustic_snare]s Rs [bass_drum]s [acoustic_snare]i [bass_drum]i [acoustic_snare]s [acoustic_snare]s Rs [bass_drum]s [acoustic_snare]i [bass_drum]i [acoustic_snare]s [acoustic_snare]s Rs [bass_drum]s [acoustic_snare]i [bass_drum]i [acoustic_snare]s [acoustic_snare]s Rs [bass_drum]s [acoustic_snare]i [bass_drum]i [acoustic_snare]s [acoustic_snare]s [HI_TOM]s* [HI_TOM]s* [HI_TOM]s* [hi_mid_tom]s* [hi_mid_tom]s* [hi_mid_tom]s* [LO_MID_TOM]s* [LO_MID_TOM]s* [LO_MID_TOM]s* [LO_TOM]s* [LO_TOM]s* [LO_TOM]s* [closed_hi_hat]s+[bass_drum]s [closed_hi_hat]s [closed_hi_hat]s [closed_hi_hat]s [closed_hi_hat]s+[acoustic_snare]s [closed_hi_hat]s [closed_hi_hat]s [closed_hi_hat]s+[acoustic_snare]s [closed_hi_hat]s [closed_hi_hat]s+[acoustic_snare]s [closed_hi_hat]s [open_hi_hat]s+[bass_drum]s [closed_hi_hat]s+[acoustic_snare]s [closed_hi_hat]s [closed_hi_hat]s [closed_hi_hat]s [closed_hi_hat]s+[bass_drum]s [closed_hi_hat]s [closed_hi_hat]s [closed_hi_hat]s [closed_hi_hat]s+[acoustic_snare]s [closed_hi_hat]s [closed_hi_hat]s [closed_hi_hat]s+[acoustic_snare]s [closed_hi_hat]s [closed_hi_hat]s+[acoustic_snare]s [closed_hi_hat]s [open_hi_hat]s+[bass_drum]s [closed_hi_hat]s+[acoustic_snare]s [closed_hi_hat]s [closed_hi_hat]s [closed_hi_hat]s [closed_hi_hat]s+[bass_drum]s [closed_hi_hat]s [closed_hi_hat]s [closed_hi_hat]s [closed_hi_hat]s+[acoustic_snare]s [closed_hi_hat]s [closed_hi_hat]s [closed_hi_hat]s+[acoustic_snare]s [closed_hi_hat]s [closed_hi_hat]s+[acoustic_snare]s [closed_hi_hat]s [open_hi_hat]s+[bass_drum]s [closed_hi_hat]s+[acoustic_snare]s [closed_hi_hat]s [closed_hi_hat]s [closed_hi_hat]s [closed_hi_hat]s+[bass_drum]s [closed_hi_hat]s [closed_hi_hat]s [closed_hi_hat]s [closed_hi_hat]s+[acoustic_snare]s [closed_hi_hat]s [closed_hi_hat]s [closed_hi_hat]s+[acoustic_snare]s [closed_hi_hat]s [closed_hi_hat]s+[acoustic_snare]s [closed_hi_hat]s [open_hi_hat]s+[bass_drum]s [closed_hi_hat]s+[acoustic_snare]s [closed_hi_hat]s [closed_hi_hat]s [closed_hi_hat]s [closed_hi_hat]s+[bass_drum]s [closed_hi_hat]s [closed_hi_hat]s [closed_hi_hat]s [closed_hi_hat]s+[acoustic_snare]s [closed_hi_hat]s [closed_hi_hat]s [closed_hi_hat]s+[acoustic_snare]s [closed_hi_hat]s [closed_hi_hat]s+[acoustic_snare]s [closed_hi_hat]s [open_hi_hat]s+[bass_drum]s [closed_hi_hat]s+[acoustic_snare]s [closed_hi_hat]s [closed_hi_hat]s [closed_hi_hat]s [closed_hi_hat]s+[bass_drum]s [closed_hi_hat]s [closed_hi_hat]s [closed_hi_hat]s [closed_hi_hat]s+[acoustic_snare]s [closed_hi_hat]s [closed_hi_hat]s [closed_hi_hat]s+[acoustic_snare]s [closed_hi_hat]s [closed_hi_hat]s+[acoustic_snare]s [closed_hi_hat]s [open_hi_hat]s+[bass_drum]s [closed_hi_hat]s+[acoustic_snare]s [closed_hi_hat]s [closed_hi_hat]s [closed_hi_hat]s [closed_hi_hat]s+[bass_drum]s [closed_hi_hat]s [closed_hi_hat]s [closed_hi_hat]s [closed_hi_hat]s+[acoustic_snare]s [closed_hi_hat]s [closed_hi_hat]s [closed_hi_hat]s+[acoustic_snare]s [closed_hi_hat]s [closed_hi_hat]s+[acoustic_snare]s [closed_hi_hat]s [open_hi_hat]s+[bass_drum]s [closed_hi_hat]s+[acoustic_snare]s [closed_hi_hat]s [closed_hi_hat]s [closed_hi_hat]s [HI_TOM]s+[crash_cymbal_1]s [hi_mid_tom]s [LO_MID_TOM]s [LO_TOM]s+[crash_cymbal_2]s [bass_drum]i [acoustic_snare]s [acoustic_snare]s Rs [bass_drum]s [acoustic_snare]i [bass_drum]i [acoustic_snare]s [acoustic_snare]s Rs [bass_drum]s [acoustic_snare]i [bass_drum]i [acoustic_snare]s [acoustic_snare]s Rs [bass_drum]s [acoustic_snare]i [bass_drum]i [acoustic_snare]s [acoustic_snare]s Rs [bass_drum]s [acoustic_snare]i [bass_drum]i [acoustic_snare]s [acoustic_snare]s Rs [bass_drum]s [acoustic_snare]i [bass_drum]i [acoustic_snare]s [acoustic_snare]s Rs [bass_drum]s [acoustic_snare]i [bass_drum]i [acoustic_snare]s [acoustic_snare]s Rs [bass_drum]s [acoustic_snare]i [bass_drum]i [acoustic_snare]s [acoustic_snare]s [HI_TOM]s* [HI_TOM]s* [HI_TOM]s* [hi_mid_tom]s* [hi_mid_tom]s* [hi_mid_tom]s* [LO_MID_TOM]s* [LO_MID_TOM]s* [LO_MID_TOM]s* [LO_TOM]s* [LO_TOM]s* [LO_TOM]s* [closed_hi_hat]s+[bass_drum]s [closed_hi_hat]s [closed_hi_hat]s [closed_hi_hat]s [closed_hi_hat]s+[acoustic_snare]s [closed_hi_hat]s [closed_hi_hat]s [closed_hi_hat]s+[acoustic_snare]s [closed_hi_hat]s [closed_hi_hat]s+[acoustic_snare]s [closed_hi_hat]s [open_hi_hat]s+[bass_drum]s [closed_hi_hat]s+[acoustic_snare]s [closed_hi_hat]s [closed_hi_hat]s [closed_hi_hat]s [closed_hi_hat]s+[bass_drum]s [closed_hi_hat]s [closed_hi_hat]s [closed_hi_hat]s [closed_hi_hat]s+[acoustic_snare]s [closed_hi_hat]s [closed_hi_hat]s [closed_hi_hat]s+[acoustic_snare]s [closed_hi_hat]s [closed_hi_hat]s+[acoustic_snare]s [closed_hi_hat]s [open_hi_hat]s+[bass_drum]s [closed_hi_hat]s+[acoustic_snare]s [closed_hi_hat]s [closed_hi_hat]s [closed_hi_hat]s [closed_hi_hat]s+[bass_drum]s [closed_hi_hat]s [closed_hi_hat]s [closed_hi_hat]s [closed_hi_hat]s+[acoustic_snare]s [closed_hi_hat]s [closed_hi_hat]s [closed_hi_hat]s+[acoustic_snare]s [closed_hi_hat]s [closed_hi_hat]s+[acoustic_snare]s [closed_hi_hat]s [open_hi_hat]s+[bass_drum]s [closed_hi_hat]s+[acoustic_snare]s [closed_hi_hat]s [closed_hi_hat]s [closed_hi_hat]s [closed_hi_hat]s+[bass_drum]s [closed_hi_hat]s [closed_hi_hat]s [closed_hi_hat]s [closed_hi_hat]s+[acoustic_snare]s [closed_hi_hat]s [closed_hi_hat]s [closed_hi_hat]s+[acoustic_snare]s [closed_hi_hat]s [closed_hi_hat]s+[acoustic_snare]s [closed_hi_hat]s [open_hi_hat]s+[bass_drum]s [closed_hi_hat]s+[acoustic_snare]s [closed_hi_hat]s [closed_hi_hat]s [closed_hi_hat]s [closed_hi_hat]s+[bass_drum]s [closed_hi_hat]s [closed_hi_hat]s [closed_hi_hat]s [closed_hi_hat]s+[acoustic_snare]s [closed_hi_hat]s [closed_hi_hat]s [closed_hi_hat]s+[acoustic_snare]s [closed_hi_hat]s [closed_hi_hat]s+[acoustic_snare]s [closed_hi_hat]s [open_hi_hat]s+[bass_drum]s [closed_hi_hat]s+[acoustic_snare]s [closed_hi_hat]s [closed_hi_hat]s [closed_hi_hat]s [closed_hi_hat]s+[bass_drum]s [closed_hi_hat]s [closed_hi_hat]s [closed_hi_hat]s [closed_hi_hat]s+[acoustic_snare]s [closed_hi_hat]s [closed_hi_hat]s [closed_hi_hat]s+[acoustic_snare]s [closed_hi_hat]s [closed_hi_hat]s+[acoustic_snare]s [closed_hi_hat]s [open_hi_hat]s+[bass_drum]s [closed_hi_hat]s+[acoustic_snare]s [closed_hi_hat]s [closed_hi_hat]s [closed_hi_hat]s [closed_hi_hat]s+[bass_drum]s [closed_hi_hat]s [closed_hi_hat]s [closed_hi_hat]s [closed_hi_hat]s+[acoustic_snare]s [closed_hi_hat]s [closed_hi_hat]s [closed_hi_hat]s+[acoustic_snare]s [closed_hi_hat]s [closed_hi_hat]s+[acoustic_snare]s [closed_hi_hat]s [open_hi_hat]s+[bass_drum]s [closed_hi_hat]s+[acoustic_snare]s [closed_hi_hat]s [closed_hi_hat]s [closed_hi_hat]s [HI_TOM]s+[crash_cymbal_1]s [hi_mid_tom]s [LO_MID_TOM]s [LO_TOM]s+[crash_cymbal_2]s [closed_hi_hat]s+[bass_drum]s [closed_hi_hat]s [closed_hi_hat]s [closed_hi_hat]s [closed_hi_hat]s+[acoustic_snare]s [closed_hi_hat]s [closed_hi_hat]s [closed_hi_hat]s+[acoustic_snare]s [closed_hi_hat]s [closed_hi_hat]s+[acoustic_snare]s [closed_hi_hat]s [open_hi_hat]s+[bass_drum]s [closed_hi_hat]s+[acoustic_snare]s [closed_hi_hat]s [closed_hi_hat]s [closed_hi_hat]s [closed_hi_hat]s+[bass_drum]s [closed_hi_hat]s [closed_hi_hat]s [closed_hi_hat]s [closed_hi_hat]s+[acoustic_snare]s [closed_hi_hat]s [closed_hi_hat]s [closed_hi_hat]s+[acoustic_snare]s [closed_hi_hat]s [closed_hi_hat]s+[acoustic_snare]s [closed_hi_hat]s [open_hi_hat]s+[bass_drum]s [closed_hi_hat]s+[acoustic_snare]s [closed_hi_hat]s [closed_hi_hat]s [closed_hi_hat]s [closed_hi_hat]s+[bass_drum]s [closed_hi_hat]s [closed_hi_hat]s [closed_hi_hat]s [closed_hi_hat]s+[acoustic_snare]s [closed_hi_hat]s [closed_hi_hat]s [closed_hi_hat]s+[acoustic_snare]s [closed_hi_hat]s [closed_hi_hat]s+[acoustic_snare]s [closed_hi_hat]s [open_hi_hat]s+[bass_drum]s [closed_hi_hat]s+[acoustic_snare]s [closed_hi_hat]s [closed_hi_hat]s [closed_hi_hat]s [closed_hi_hat]s+[bass_drum]s [closed_hi_hat]s [closed_hi_hat]s [closed_hi_hat]s [closed_hi_hat]s+[acoustic_snare]s [closed_hi_hat]s [closed_hi_hat]s [closed_hi_hat]s+[acoustic_snare]s [closed_hi_hat]s [closed_hi_hat]s+[acoustic_snare]s [closed_hi_hat]s [open_hi_hat]s+[bass_drum]s [closed_hi_hat]s+[acoustic_snare]s [closed_hi_hat]s [closed_hi_hat]s [closed_hi_hat]s [closed_hi_hat]s+[bass_drum]s [closed_hi_hat]s [closed_hi_hat]s [closed_hi_hat]s [closed_hi_hat]s+[acoustic_snare]s [closed_hi_hat]s [closed_hi_hat]s [closed_hi_hat]s+[acoustic_snare]s [closed_hi_hat]s [closed_hi_hat]s+[acoustic_snare]s [closed_hi_hat]s [open_hi_hat]s+[bass_drum]s [closed_hi_hat]s+[acoustic_snare]s [closed_hi_hat]s [closed_hi_hat]s [closed_hi_hat]s [closed_hi_hat]s+[bass_drum]s [closed_hi_hat]s [closed_hi_hat]s [closed_hi_hat]s [closed_hi_hat]s+[acoustic_snare]s [closed_hi_hat]s [closed_hi_hat]s [closed_hi_hat]s+[acoustic_snare]s [closed_hi_hat]s [closed_hi_hat]s+[acoustic_snare]s [closed_hi_hat]s [open_hi_hat]s+[bass_drum]s [closed_hi_hat]s+[acoustic_snare]s [closed_hi_hat]s [closed_hi_hat]s [closed_hi_hat]s [closed_hi_hat]s+[bass_drum]s [closed_hi_hat]s [closed_hi_hat]s [closed_hi_hat]s [closed_hi_hat]s+[acoustic_snare]s [closed_hi_hat]s [closed_hi_hat]s [closed_hi_hat]s+[acoustic_snare]s [closed_hi_hat]s [closed_hi_hat]s+[acoustic_snare]s [closed_hi_hat]s [open_hi_hat]s+[bass_drum]s [closed_hi_hat]s+[acoustic_snare]s [closed_hi_hat]s [closed_hi_hat]s [closed_hi_hat]s [HI_TOM]s* [HI_TOM]s* [HI_TOM]s* [hi_mid_tom]s* [hi_mid_tom]s* [hi_mid_tom]s* [LO_MID_TOM]s* [LO_MID_TOM]s* [LO_MID_TOM]s* [LO_TOM]s* [LO_TOM]s* [LO_TOM]s* [closed_hi_hat]s+[bass_drum]s [closed_hi_hat]s [closed_hi_hat]s [closed_hi_hat]s [closed_hi_hat]s+[acoustic_snare]s [closed_hi_hat]s [closed_hi_hat]s [closed_hi_hat]s+[acoustic_snare]s [closed_hi_hat]s [closed_hi_hat]s+[acoustic_snare]s [closed_hi_hat]s [open_hi_hat]s+[bass_drum]s [closed_hi_hat]s+[acoustic_snare]s [closed_hi_hat]s [closed_hi_hat]s [closed_hi_hat]s [closed_hi_hat]s+[bass_drum]s [closed_hi_hat]s [closed_hi_hat]s [closed_hi_hat]s [closed_hi_hat]s+[acoustic_snare]s [closed_hi_hat]s [closed_hi_hat]s [closed_hi_hat]s+[acoustic_snare]s [closed_hi_hat]s [closed_hi_hat]s+[acoustic_snare]s [closed_hi_hat]s [open_hi_hat]s+[bass_drum]s [closed_hi_hat]s+[acoustic_snare]s [closed_hi_hat]s [closed_hi_hat]s [closed_hi_hat]s [closed_hi_hat]s+[bass_drum]s [closed_hi_hat]s [closed_hi_hat]s [closed_hi_hat]s [closed_hi_hat]s+[acoustic_snare]s [closed_hi_hat]s [closed_hi_hat]s [closed_hi_hat]s+[acoustic_snare]s [closed_hi_hat]s [closed_hi_hat]s+[acoustic_snare]s [closed_hi_hat]s [open_hi_hat]s+[bass_drum]s [closed_hi_hat]s+[acoustic_snare]s [closed_hi_hat]s [closed_hi_hat]s [closed_hi_hat]s [closed_hi_hat]s+[bass_drum]s [closed_hi_hat]s [closed_hi_hat]s [closed_hi_hat]s [closed_hi_hat]s+[acoustic_snare]s [closed_hi_hat]s [closed_hi_hat]s [closed_hi_hat]s+[acoustic_snare]s [closed_hi_hat]s [closed_hi_hat]s+[acoustic_snare]s [closed_hi_hat]s [open_hi_hat]s+[bass_drum]s [closed_hi_hat]s+[acoustic_snare]s [closed_hi_hat]s [closed_hi_hat]s [closed_hi_hat]s [closed_hi_hat]s+[bass_drum]s [closed_hi_hat]s [closed_hi_hat]s [closed_hi_hat]s [closed_hi_hat]s+[acoustic_snare]s [closed_hi_hat]s [closed_hi_hat]s [closed_hi_hat]s+[acoustic_snare]s [closed_hi_hat]s [closed_hi_hat]s+[acoustic_snare]s [closed_hi_hat]s [open_hi_hat]s+[bass_drum]s [closed_hi_hat]s+[acoustic_snare]s [closed_hi_hat]s [closed_hi_hat]s [closed_hi_hat]s [closed_hi_hat]s+[bass_drum]s [closed_hi_hat]s [closed_hi_hat]s [closed_hi_hat]s [closed_hi_hat]s+[acoustic_snare]s [closed_hi_hat]s [closed_hi_hat]s [closed_hi_hat]s+[acoustic_snare]s [closed_hi_hat]s [closed_hi_hat]s+[acoustic_snare]s [closed_hi_hat]s [open_hi_hat]s+[bass_drum]s [closed_hi_hat]s+[acoustic_snare]s [closed_hi_hat]s [closed_hi_hat]s [closed_hi_hat]s [closed_hi_hat]s+[bass_drum]s [closed_hi_hat]s [closed_hi_hat]s [closed_hi_hat]s [closed_hi_hat]s+[acoustic_snare]s [closed_hi_hat]s [closed_hi_hat]s [closed_hi_hat]s+[acoustic_snare]s [closed_hi_hat]s [closed_hi_hat]s+[acoustic_snare]s [closed_hi_hat]s [open_hi_hat]s+[bass_drum]s [closed_hi_hat]s+[acoustic_snare]s [closed_hi_hat]s [closed_hi_hat]s [closed_hi_hat]s [HI_TOM]s+[crash_cymbal_1]s [hi_mid_tom]s [LO_MID_TOM]s [LO_TOM]s+[crash_cymbal_2]s [bass_drum]i [acoustic_snare]s [acoustic_snare]s Rs [bass_drum]s [acoustic_snare]i [bass_drum]i [acoustic_snare]s [acoustic_snare]s Rs [bass_drum]s [acoustic_snare]i [bass_drum]i [acoustic_snare]s [acoustic_snare]s Rs [bass_drum]s [acoustic_snare]i [bass_drum]i [acoustic_snare]s [acoustic_snare]s Rs [bass_drum]s [acoustic_snare]i [bass_drum]i [acoustic_snare]s [acoustic_snare]s Rs [bass_drum]s [acoustic_snare]i [bass_drum]i [acoustic_snare]s [acoustic_snare]s Rs [bass_drum]s [acoustic_snare]i [bass_drum]i [acoustic_snare]s [acoustic_snare]s Rs [bass_drum]s [acoustic_snare]i [bass_drum]i [acoustic_snare]s [acoustic_snare]s [HI_TOM]s+[crash_cymbal_1]s [hi_mid_tom]s [LO_MID_TOM]s [LO_TOM]s+[crash_cymbal_2]s [crash_cymbal_1]w V0 I24 Amajq Amajq Amajq Amajq Emajq Emajq Emajq Emajq F#minq F#minq F#minq F#minq Dmajq Dmajq Dmajq Dmajq Amajq Amajq Amajq Amajq Dmajq Dmajq Dmajq Dmajq Emajq Emajq Emajq Emajq Dmajq Dmajq Dmajq Dmajq F#minh Dmajh Amajh Emajh F#minh Dmajh Amajh Emajh F#minh Dmajh Amajh Emajh F#minh Dmajh Amajh Emajh Amajq Amajq Amajq Amajq Dmajq Dmajq Dmajq Dmajq Emajq Emajq Emajq Emajq Dmajq Dmajq Dmajq Dmajq F#minh Dmajh Amajh Emajh F#minh Dmajh Amajh Emajh F#minh Dmajh Amajh Emajh F#minh Dmajh Amajh Emajh F#minq F#minq Emajq Emajq Dmajq Dmajq Emajq Emajq F#minq F#minq Emajq Emajq Dmajq Dmajq Emajq Emajq F#minq F#minq Emajq Emajq Dmajq Dmajq Emajq Emajq F#minq F#minq Emajq Emajq Dmajq Dmajq Emajq Emajq F#minh Dmajh Amajh Emajh F#minh Dmajh Amajh Emajh F#minh Dmajh Amajh Emajh F#minh Dmajh Amajh Emajh F#mini F#mini F#mini F#mini Emaji Emaji Emaji Emaji Dmaji Dmaji Dmaji Dmaji Emaji Emaji Emaji Emaji F#mini F#mini F#mini F#mini Emaji Emaji Emaji Emaji Dmaji Dmaji Dmaji Dmaji Emaji Emaji Emaji Emaji Amajw V1 I0 Eq Aq C#w Di Ei Ai C#w Assssssss Dw C#q. Ai Bq Ai C#i Bw As Es F#s Esssss Bw Bw Ds Ah. Bi C#i Bq. C#i Aq. Di C#q. Ei Ah Bq Dq C#h. Eq Dw C#i E Bw C#q. Ai Bq Ai C#i Bw As Es F#s Esssss Bw Bw Ds Ah. Bi C#i Bq. C#i Aq. Di C#q. Ei Ah Bq Dq C#h. Eq Dw C#i E Bw Eh. Dq Aq C#q Ew Di. C#s Es F#h. G#q Aq Bh. Dq Ah. Bq Dq Ei Di Eq C# Bw Bw Ds Ah. Bi C#i Bq. C#i Aq. Di C#q. Ei Ah Bq Dq C#h. Eq Dw C#i E Bw Bq. C#i Ei Dw C#q Ah. Dq Essssssss Dw Aw");
		Player player = new Player();
		player.play(pattern);
	}
}
