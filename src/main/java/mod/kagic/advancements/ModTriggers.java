package mod.kagic.advancements;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import mod.kagic.init.KAGIC;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.advancements.ICriterionTrigger;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.ReflectionHelper;

public class ModTriggers

    {
        public static final CustomTrigger PLACE_CLOUD_SAPLING = new CustomTrigger("place_cloud_sapling");
    
        /*
         * This array just makes it convenient to register all the criteria.
         */
        public static final CustomTrigger[] TRIGGER_ARRAY = new CustomTrigger[] {
                PLACE_CLOUD_SAPLING
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