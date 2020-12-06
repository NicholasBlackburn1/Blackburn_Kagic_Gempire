package mod.kagic.advancements;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.advancements.ICriterionTrigger;
import net.minecraftforge.fml.relauncher.ReflectionHelper;

public class ModTriggers {
    public static final CustomTrigger STARTING_KAGIC_BLAKCBURN = new CustomTrigger("starting_kagic_blackburn");

    /*
     * This array just makes it convenient to register all the criteria.
     */
    public static final CustomTrigger[] TRIGGER_ARRAY = new CustomTrigger[] {
        STARTING_KAGIC_BLAKCBURN
            };


        public static void registerTriggers()
            {
                // DEBUG
                System.out.println("Registering custom triggers");
                
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
                        e.printStackTrace();
                    }
                } 
            }
        }
        
