package com.enjin.angelcraftonomy.commands;

import org.bukkit.FireworkEffect;
import org.bukkit.FireworkEffect.Type;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.inventory.meta.FireworkMeta;

import java.util.ArrayList;
import java.util.Random;

import org.bukkit.Color;

import com.enjin.angelcraftonomy.MultiUseCore;
import com.enjin.angelcraftonomy.extenders.CommandExtender;
import com.enjin.angelcraftonomy.interfaces.CommandInterface;

public class AutionCommand extends CommandExtender implements CommandInterface {
	

	public AutionCommand(MultiUseCore multiuse, CommandSender sender,
			Command command, String label, String[] args) {
		super(multiuse, sender, command, label, args);
	}

		@Override
		public void initialize() {
			// TODO Auto-generated method stub
			
		}


		@Override
		public void run() {
			// TODO Auto-generated method stub
			Player p = this.getPlayer();
	        sendMessage("YOU SAID AUTION!!!");
	            
	                //Spawn the Firework, get the FireworkMeta.
	                Firework fw = (Firework) p.getWorld().spawnEntity(p.getLocation(), EntityType.FIREWORK);
	                FireworkMeta fwm = fw.getFireworkMeta();    
	               
	                Random randGen = new Random();
	                
	                ArrayList<Type> types = new ArrayList<Type>();
	                ArrayList<Color> colors = new ArrayList<Color>();
	                
	                //colors
	                colors.add(Color.AQUA);
	                colors.add(Color.BLACK);
	                colors.add(Color.BLUE);
	                colors.add(Color.FUCHSIA);
	                colors.add(Color.GRAY);
	                colors.add(Color.GREEN);
	                colors.add(Color.LIME);
	                colors.add(Color.MAROON);
	                colors.add(Color.NAVY);
	                colors.add(Color.OLIVE);
	                colors.add(Color.ORANGE);
	                colors.add(Color.PURPLE);
	                colors.add(Color.RED);
	                colors.add(Color.SILVER);
	                colors.add(Color.TEAL);
	                colors.add(Color.WHITE);
	                colors.add(Color.YELLOW);
	                
	                //types
	                types.add(Type.BALL);
	                types.add(Type.BALL_LARGE);
	                types.add(Type.BURST);
	                types.add(Type.CREEPER);
	                types.add(Type.STAR);
	                
	                //get type and color
	                int randInt = randGen.nextInt(types.size());
	                Type t = types.get(randInt);
	                
	                randInt = randGen.nextInt(colors.size());
	                Color c1 = colors.get(randInt);
	                
	                randInt = randGen.nextInt(colors.size());
	                Color c2 = colors.get(randInt);
	                
	                FireworkEffect effect = FireworkEffect.builder().withFlicker().withColor(c1).withFade(c2).with(t).withTrail().build();
	               
	                //Then apply the effect to the meta
	                fwm.addEffect(effect);
	               
	                //Generate some random power and set it
	                fwm.setPower(3);
	               
	                //Then apply this to our rocket
	                fw.setFireworkMeta(fwm);           
	        }
		
		
		@Override
		 public void sendNoPermMessage() {
		  super.sendNoPermMessage();
		 }


		@Override
		public void cleanup() {
			// TODO Auto-generated method stub
			
		}
	   
}
