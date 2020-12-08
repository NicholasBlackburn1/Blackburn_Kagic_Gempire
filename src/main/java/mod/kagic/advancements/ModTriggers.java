package mod.kagic.advancements;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import mod.kagic.init.KAGIC;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.advancements.ICriterionTrigger;
import net.minecraft.client.gui.toasts.AdvancementToast;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.ReflectionHelper;

public class ModTriggers


    {
       
        public static final CustomTrigger MOD_START = new CustomTrigger("mod_start");
        public static final CustomTrigger BATTLE_FIELD = new CustomTrigger("straw_berry");
        public static final CustomTrigger GALAXY_WARP = new CustomTrigger("galaxy_warp");
        public static final CustomTrigger DESERT_TEMPLE = new CustomTrigger("desert_temple");
        public static final CustomTrigger COMMUNICATION_HUB = new CustomTrigger("communication_hub");
        public static final CustomTrigger KINDERGARDEN = new CustomTrigger("kindergarden");
        public static final CustomTrigger MOON_GODAS = new CustomTrigger("moon_godas");
        public static final CustomTrigger HEAVEN_BEATLE = new CustomTrigger("heaven_beatle");
        public static final CustomTrigger STRONGER_TOGETHER =new CustomTrigger("stronger_together");

        
       
        
        /*
         * This array just makes it convenient to register all the criteria.
         */
        public static final CustomTrigger[] TRIGGER_ARRAY = new CustomTrigger[] {
            MOD_START,BATTLE_FIELD,GALAXY_WARP,DESERT_TEMPLE,COMMUNICATION_HUB,KINDERGARDEN,MOON_GODAS, HEAVEN_BEATLE,STRONGER_TOGETHER
                };
    
    
        /**
         * This method is part of my simple custom advancement triggering tutorial.
         * See: http://jabelarminecraft.blogspot.com/p/minecraft-modding-custom-triggers-aka.html
         */
        public static void registerTriggers()
        {
            // DEBUG
            KAGIC.logger.debug("Registering custom triggers");
            
            Method method;
    
            method = ReflectionHelper.findMethod(CriteriaTriggers.class, "register", "func_192118_a", ICriterionTrigger.class);
    
            method.setAccessible(true);
            
    
            for (int i=0; i < TRIGGER_ARRAY.length; i++)
            {
                 try
                {
                    method.invoke(null, TRIGGER_ARRAY[i]);
                }
                catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e)
                {
                    // TODO Auto-generated catch block
                    KAGIC.logger.debug(e);
                }
            } 
        }
    }