package com.nameless.theforcelawtweaks.gameasset;

import com.nameless.theforcelawtweaks.main.TheForceLawTweaks;
import com.nameless.theforcelawtweaks.skill.weaponinnateskill.HeavyAttack;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import yesman.epicfight.api.data.reloader.SkillManager;
import yesman.epicfight.api.forgeevent.SkillBuildEvent;
import yesman.epicfight.skill.Skill;
import yesman.epicfight.skill.dodge.DodgeSkill;
import yesman.epicfight.skill.weaponinnate.WeaponInnateSkill;

@Mod.EventBusSubscriber(modid = TheForceLawTweaks.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class LOWSkills {
    public static Skill DUAL_TACHI_SWORD_HEAVY_ATTACK;
    public static Skill HAND_HALF_SWORD_HEAVY_ATTACK;

    public static Skill COLOSSALSWORD_HEAVY_ATTACK;
    public static Skill ROLL;
    public static Skill SLIDING;


    public static void registerSkills(){
        SkillManager.register(HeavyAttack::new, HeavyAttack.createHeavyAttackBuilder()
            .setAnimations(new ResourceLocation(TheForceLawTweaks.MODID,"biped/combat/handhalfsword_heavyattack_1"),
                    new ResourceLocation(TheForceLawTweaks.MODID,"biped/combat/handhalfsword_heavyattack_2"))
                   ,TheForceLawTweaks.MODID,"handhalfsword_heavyattak");

        SkillManager.register(HeavyAttack::new, HeavyAttack.createHeavyAttackBuilder()
                .setAnimations(
                               new ResourceLocation(TheForceLawTweaks.MODID,"biped/combat/dual_tachi/uchigatana_heavy2"),
        new ResourceLocation(TheForceLawTweaks.MODID,"biped/combat/dual_tachi/uchigatana_heavy1")) ,
                               TheForceLawTweaks.MODID,"uchigatana_heavyattak");

        SkillManager.register(HeavyAttack::new, HeavyAttack.createHeavyAttackBuilder()
                        .setAnimations(new ResourceLocation(TheForceLawTweaks.MODID,"biped/combat/colossalsword/colossalsword_heavy1"),
                                new ResourceLocation(TheForceLawTweaks.MODID,"biped/combat/colossalsword/colossalsword_heavy2")) ,
                TheForceLawTweaks.MODID,"colossalsword_heavyattak");
        SkillManager.register(DodgeSkill::new, DodgeSkill.createDodgeBuilder()
                .setAnimations(new ResourceLocation[]{new ResourceLocation(TheForceLawTweaks.MODID, "biped/skill/roll_front"),
                        new ResourceLocation(TheForceLawTweaks.MODID, "biped/skill/roll_after"),
                        new ResourceLocation(TheForceLawTweaks.MODID, "biped/skill/roll_right"),
                        new ResourceLocation(TheForceLawTweaks.MODID, "biped/skill/roll_left")}), TheForceLawTweaks.MODID, "roll");



        SkillManager.register(DodgeSkill::new, DodgeSkill.createDodgeBuilder()
                .setAnimations(new ResourceLocation[]{new ResourceLocation(TheForceLawTweaks.MODID, "biped/skill/slidingstep_front"),
                       new ResourceLocation(TheForceLawTweaks.MODID, "biped/skill/slidingstep_after"),
                        new ResourceLocation(TheForceLawTweaks.MODID, "biped/skill/slidingstep_right"),
                        new ResourceLocation(TheForceLawTweaks.MODID, "biped/skill/slidingstep_left")}), TheForceLawTweaks.MODID, "sliding");


    }

    @SubscribeEvent
    public static void buildSkillEvent(SkillBuildEvent onBuild) {
        HAND_HALF_SWORD_HEAVY_ATTACK = onBuild.<WeaponInnateSkill, Skill.Builder<WeaponInnateSkill>>build(TheForceLawTweaks.MODID, "handhalfsword_heavyattak");
        COLOSSALSWORD_HEAVY_ATTACK = onBuild.<WeaponInnateSkill, Skill.Builder<WeaponInnateSkill>>build(TheForceLawTweaks.MODID, "colossalsword_heavyattak");
        DUAL_TACHI_SWORD_HEAVY_ATTACK = onBuild.<WeaponInnateSkill, Skill.Builder<WeaponInnateSkill>>build(TheForceLawTweaks.MODID, "uchigatana_heavyattak");
        ROLL = onBuild.build(TheForceLawTweaks.MODID, "roll");
        SLIDING = onBuild.build(TheForceLawTweaks.MODID, "sliding");

    }
}
