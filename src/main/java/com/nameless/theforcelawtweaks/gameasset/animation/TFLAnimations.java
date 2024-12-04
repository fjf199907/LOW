package com.nameless.theforcelawtweaks.gameasset.animation;

import com.mojang.datafixers.util.Pair;
import com.nameless.theforcelawtweaks.api.BasicAttackWinAnimation;
import com.nameless.theforcelawtweaks.client.keymappings.TFLKeyMappings;
import com.nameless.theforcelawtweaks.client.mobs.cowdevil.patch.CowDevilArmature;
import com.nameless.theforcelawtweaks.main.TheForceLawTweaks;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import org.joml.Vector3d;
import yesman.epicfight.api.animation.property.AnimationEvent;
import yesman.epicfight.api.animation.property.AnimationProperty;
import yesman.epicfight.api.animation.property.MoveCoordFunctions;
import yesman.epicfight.api.animation.types.*;
import yesman.epicfight.api.forgeevent.AnimationRegistryEvent;
import yesman.epicfight.api.utils.AttackResult;
import yesman.epicfight.api.utils.TimePairList;
import yesman.epicfight.api.utils.math.ValueModifier;
import yesman.epicfight.api.utils.math.Vec3f;
import yesman.epicfight.client.input.EpicFightKeyMappings;
import yesman.epicfight.gameasset.Animations;
import yesman.epicfight.gameasset.Armatures;
import yesman.epicfight.gameasset.ColliderPreset;
import yesman.epicfight.gameasset.EpicFightSounds;
import yesman.epicfight.model.armature.DragonArmature;
import yesman.epicfight.model.armature.HumanoidArmature;
import yesman.epicfight.particle.EpicFightParticles;
import yesman.epicfight.skill.BasicAttack;
import yesman.epicfight.skill.SkillSlots;
import yesman.epicfight.world.capabilities.entitypatch.player.ServerPlayerPatch;
import yesman.epicfight.world.damagesource.ExtraDamageInstance;
import yesman.epicfight.world.damagesource.StunType;
import yesman.epicfight.world.effect.EpicFightMobEffects;
import yesman.epicfight.world.entity.eventlistener.ComboCounterHandleEvent;
import com.nameless.theforcelawtweaks.client.mobs.cowdevil.patch.CowDevilArmature;
import java.util.List;
import java.util.Set;

import static yesman.epicfight.api.animation.types.DodgeAnimation.DODGEABLE_SOURCE_VALIDATOR;

public class TFLAnimations {
        public static StaticAnimation HANDHALFSWORD_AUTO1;
        public static StaticAnimation HANDHALFSWORD_AUTO2;
        public static StaticAnimation HANDHALFSWORD_AUTO3;
        public static StaticAnimation HANDHALFSWORD_AUTO4;
        public static StaticAnimation HANDHALFSWORD_AUTO5;
        public static StaticAnimation HANDHALFSWORD_DASH;
        public static StaticAnimation HANDHALFSWORD_HEAVY_ATTACK1;
        public static StaticAnimation HANDHALFSWORD_HEAVY_ATTACK2;
        public static StaticAnimation HANDHALFSWORD_DODGE_ATTACK1;
        public static StaticAnimation HANDHALFSWORD_DODGE_ATTACK1_L;
        public static StaticAnimation HANDHALFSWORD_DODGE_ATTACK1_R;
        public static StaticAnimation HANDHALFSWORD_DODGE_ATTACK2;
        public static StaticAnimation HANDHALFSWORD_DODGE_ATTACK2_L;
        public static StaticAnimation HANDHALFSWORD_DODGE_ATTACK2_R;
        public static StaticAnimation PURSUIT_LIGHT;
        public static StaticAnimation PURSUIT_HEAVY;
        public static StaticAnimation PURSUIT;
        public static StaticAnimation HANDHALFSWORD_AIRSLASH;
        public static StaticAnimation HANDHALFSWORD_DUAL_AUTO1;
        public static StaticAnimation HANDHALFSWORD_DUAL_AUTO2;
        public static StaticAnimation HANDHALFSWORD_DUAL_AUTO3;
        public static StaticAnimation HANDHALFSWORD_DUAL_AUTO4;
        public static StaticAnimation HANDHALFSWORD_DUAL_AUTO5;
        public static StaticAnimation HANDHALFSWORD_DUAL_DASH;
        public static StaticAnimation HANDHALFSWORD_DUAL_AIRSLASH;
        public static StaticAnimation SQUAREOFF_ON;
        public static StaticAnimation SQUAREOFF_OFF;
        // sik
        public static StaticAnimation SQUAREOFF_LOOP;
        public static StaticAnimation SQUAREOFF_WALK;
        public static StaticAnimation SQUAREOFF_BLOCKATTACK;
        public static StaticAnimation SQUAREOFF_HEAVY;
        public static StaticAnimation SQUAREOFF_HIT;
        public static StaticAnimation SQUAREOFF_LIGHT;

        // new
        public static StaticAnimation IDEL0;
        public static StaticAnimation IDEL1;
        public static StaticAnimation RUN;
        public static StaticAnimation WALK;
        public static StaticAnimation SHIELD;
        public static StaticAnimation SHIELD_BOKEN;
        public static StaticAnimation SHIELD_HIT1;
        public static StaticAnimation SHIELD_HIT2;
        public static StaticAnimation SHIELD_HIT3;
        public static StaticAnimation SHIELD_HIT4;
        public static StaticAnimation SLASH_SHIELD;
        public static StaticAnimation SLASH_SPEAR;
        public static StaticAnimation SPEAR_AUTO1;
        public static StaticAnimation SPEAR_AUTO2;
        public static StaticAnimation SPEAR_AUTO3;
        public static StaticAnimation SPEAR_SPECIAL;
        public static StaticAnimation SPEAR_SWEEP;
        public static StaticAnimation COLOSSALSWORD_IDLE;
        public static StaticAnimation COLOSSALSWORD_AUTO1;
        public static StaticAnimation COLOSSALSWORD_AUTO2;
        public static StaticAnimation COLOSSALSWORD_AUTO3;
        public static StaticAnimation COLOSSALSWORD_AUTO4;
        public static StaticAnimation COLOSSALSWORD_AUTO5;
        public static StaticAnimation COLOSSALSWORD_HEAVY_ATTACK1;
        public static StaticAnimation COLOSSALSWORD_HEAVY_ATTACK2;
        public static StaticAnimation EXECUTE;
        public static StaticAnimation EXECUTEED;
        // yullian
        public static StaticAnimation YULLIAN_COMBOA1;
        public static StaticAnimation YULLIAN_COMBOA2;
        public static StaticAnimation YULLIAN_COMBOA3;
        public static StaticAnimation YULLIAN_COMBOB1;
        public static StaticAnimation YULLIAN_COMBOC1;
        public static StaticAnimation YULLIAN_COMBOC2;
        public static StaticAnimation YULLIAN_DODGEATTACK;
        public static StaticAnimation YULLIAN_IDLE;
        public static StaticAnimation YULLIAN_JUMP_HEAVYATTACK;
        public static StaticAnimation YULLIAN_JUMPPATTACK;
        public static StaticAnimation YULLIAN_RUN;
        public static StaticAnimation YULLIAN_SPECIALATTACK1;
        public static StaticAnimation YULLIAN_SPECIALATTACK2;
        public static StaticAnimation YULLIAN_SPECIALATTACK3;
        public static StaticAnimation YULLIAN_WALK;
        public static StaticAnimation YULLIAN_DASHAHATTCK;

        public static StaticAnimation SKILL_ROLL_RIGHT;// 翻滚
        public static StaticAnimation SKILL_ROLL_AFTER;
        public static StaticAnimation SKILL_ROLL_FRONT;
        public static StaticAnimation SKILL_ROLL_LEFT;
        public static StaticAnimation SKILL_ROLL;
        public static StaticAnimation SKILL_DODGE_RIGHT;// 闪避
        public static StaticAnimation SKILL_DODGE_AFTER;
        public static StaticAnimation SKILL_DODGE_FRONT;
        public static StaticAnimation SKILL_DODGE_LEFT;

        public static StaticAnimation CWO_DEVIL_IDLE;
        public static StaticAnimation CWO_DEVIL_ATTACK;
        public static StaticAnimation YULLIAN_COMBOA4;

        public static StaticAnimation UCHIGATANA_AUTO1;
        public static StaticAnimation UCHIGATANA_AUTO2;
        public static StaticAnimation UCHIGATANA_AUTO3;
        public static StaticAnimation UCHIGATANA_AUTO4;
        public static StaticAnimation UCHIGATANA_AUTO5;
        public static StaticAnimation UCHIGATANA_DASH;
        public static StaticAnimation DUAL_TACHI_AUTO1;
        public static StaticAnimation DUAL_TACHI_AUTO2;
        public static StaticAnimation DUAL_TACHI_AUTO3;
        public static StaticAnimation DUAL_TACHI_AUTO4;
        public static StaticAnimation DUAL_TACHI_SKILL1;
        public static StaticAnimation DUAL_TACHI_SKILL2;
        public static StaticAnimation DUAL_TACHI_AUTO5;
        public static StaticAnimation TACHI_IDLE;
        public static StaticAnimation TACHI_WALK;
        public static StaticAnimation TACHI_RUN;
        public static StaticAnimation DUAL_SHORTKNIFE_AUTO1;
        public static StaticAnimation DUAL_SHORTKNIFE_AUTO2;
        public static StaticAnimation DUAL_SHORTKNIFE_AUTO3;
        public static StaticAnimation DUAL_SHORTKNIFE_AUTO4;
        public static StaticAnimation SHORTKNIFE_AUTO1;
        public static StaticAnimation SHORTKNIFE_AUTO2;
        public static StaticAnimation SHORTKNIFE_AUTO3;
        public static StaticAnimation SHORTKNIFE_AUTO4;
        public static StaticAnimation SHORTKNIFE_AUTO5;
        public static StaticAnimation SHORTKNIFE_AUTO6;
        public static StaticAnimation BIGSWORD_CLAYMORE_AUTO1;
        public static StaticAnimation BIGSWORD_CLAYMORE_AUTO2;
        public static StaticAnimation BIGSWORD_CLAYMORE_AUTO3;
        public static StaticAnimation BIGSWORD_CLAYMORE_AUTO4;
        public static StaticAnimation BIGSWORD_CLAYMORE_DASH;
        public static StaticAnimation BIGSWORD_DUAL_CLAYMORE_AUTO1;
        public static StaticAnimation BIGSWORD_DUAL_CLAYMORE_AUTO2;
        public static StaticAnimation BIGSWORD_DUAL_CLAYMORE_AUTO3;
        public static StaticAnimation BIGSWORD_DUAL_GREATWEAPON_IDLE;
        public static StaticAnimation BIGSWORD_DUAL_GREATWEAPON_RUN;
        public static StaticAnimation BIGSWORD_DUAL_GREATWEAPON_WALK;
        public static StaticAnimation BIGSWORD_GREATWEAPON_IDLE;
        public static StaticAnimation BIGSWORD_GREATWEAPON_RUN;
        public static StaticAnimation BIGSWORD_GREATWEAPON_WALK;
        public static StaticAnimation BIGSWORD_CLAYMORE_SKILL1;
        public static StaticAnimation LIONCLAW_DUAL;
        public static StaticAnimation LIONCLAW_DUAL2;
        public static StaticAnimation LIONCLAW;
        public static StaticAnimation LIONCLAW2;



        public static AnimationEvent.AnimationEventConsumer PURSUIT_EVENT = ((livingEntityPatch, staticAnimation,
                        objects) -> {
                // if(TFLKeyMappings.BASIC_ATTACK.isRelease()){
                // livingEntityPatch.playAnimationSynchronized(PURSUIT, 0.0F);
                // }
                // if (EpicFightKeyMappings.ATTACK.isDown()) {
                // livingEntityPatch.playAnimationSynchronized(PURSUIT, 0.0F);
                // }bigsword
        });

        @SubscribeEvent
        public static void registerAnimations(AnimationRegistryEvent event) {
                event.getRegistryMap().put(TheForceLawTweaks.MODID, TFLAnimations::build);
        }

        public static void build() {
                HumanoidArmature biped = Armatures.BIPED;
                CowDevilArmature bipex = com.nameless.theforcelawtweaks.gameasset.Armatures.cowDevilArmature;
                ;
                LIONCLAW = new BasicAttackAnimation( 0.1F, "biped/skill/lionclaw", biped,

                        new AttackAnimation.Phase(0F, 0.867F, 0.9F, 0F, 0.9F, InteractionHand.MAIN_HAND,biped.toolR, null)
                                .addProperty(AnimationProperty.AttackPhaseProperty.MAX_STRIKES_MODIFIER,ValueModifier.setter(1F))
                                .addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.setter(-90F))
                                .addProperty(AnimationProperty.AttackPhaseProperty.IMPACT_MODIFIER,ValueModifier.adder(10F))
                        ,
                        new AttackAnimation.Phase(0.9F, 1.5F, 1.633F,  2.167F, 2.167F, InteractionHand.MAIN_HAND,biped.toolR, null)
                                .addProperty(AnimationProperty.AttackPhaseProperty.MAX_STRIKES_MODIFIER,ValueModifier.setter(1F))
                                .addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.adder(200F))
                                .addProperty(AnimationProperty.AttackPhaseProperty.IMPACT_MODIFIER,ValueModifier.adder(100F))
                )
                        .addProperty(AnimationProperty.AttackAnimationProperty.ATTACK_SPEED_FACTOR, 1F)
                        .addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, 1F)

                        .addState(EntityState.MOVEMENT_LOCKED, true)
                        .addEvents(AnimationEvent.TimePeriodEvent.create(0.733F, 2F, (livingEntityPatch, staticAnimation, objects) -> {
                                if (livingEntityPatch instanceof ServerPlayerPatch playerPatch) {
                                        // 给自己添加减伤效果，假设我们使用"伤害减免"的效果
                                        playerPatch.getOriginal().addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 100, 0)); // 100 ticks（5秒）伤害减免
                                }
                        }, AnimationEvent.Side.SERVER));
                LIONCLAW2 = new BasicAttackAnimation( 0.1F, "biped/skill/lionclaw2", biped,

                        new AttackAnimation.Phase(0F, 0.5F,  0.667F, 0F, 0.667F, InteractionHand.MAIN_HAND,biped.toolR, null)
                                .addProperty(AnimationProperty.AttackPhaseProperty.MAX_STRIKES_MODIFIER,ValueModifier.setter(1F))
                                .addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.setter(-80F))//伤害加成
                                .addProperty(AnimationProperty.AttackPhaseProperty.IMPACT_MODIFIER,ValueModifier.adder(30F))//冲击加成
                        ,
                        new AttackAnimation.Phase(0.667F, 1F, 1.133F,  1.167F, 1.167F, InteractionHand.MAIN_HAND,biped.toolR, null)
                                .addProperty(AnimationProperty.AttackPhaseProperty.MAX_STRIKES_MODIFIER,ValueModifier.setter(1F))
                                .addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.adder(200F))
                                .addProperty(AnimationProperty.AttackPhaseProperty.IMPACT_MODIFIER,ValueModifier.adder(600F))
                         )
                        .addProperty(AnimationProperty.AttackAnimationProperty.ATTACK_SPEED_FACTOR, 1F)
                        .addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, 1F)
                        .addState(EntityState.MOVEMENT_LOCKED, true)
                        .addProperty(new AnimationProperty.StaticAnimationProperty<MobEffectInstance>(), new MobEffectInstance(EpicFightMobEffects.STUN_IMMUNITY.get(),200,0))
                        .addEvents(AnimationEvent.TimePeriodEvent.create(0.25F, 1.5F, (livingEntityPatch, staticAnimation, objects) -> {
                                if (livingEntityPatch instanceof ServerPlayerPatch playerPatch) {
                                        // 给自己添加减伤效果，假设我们使用"伤害减免"的效果
                                        //   playerPatch.getOriginal().addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 100, 0)); // 100 ticks（5秒）伤害减免
                                }
                        }, AnimationEvent.Side.SERVER));
                //indestructible @p play "theforcelawtweaks:biped/skill/lionclaw_dual" 0 0
                LIONCLAW_DUAL = new BasicAttackAnimation( 0.1F, "biped/skill/lionclaw_dual", biped,

                        new AttackAnimation.Phase(0F, 0.833F, 0.933F, 0F, 0.933F, InteractionHand.MAIN_HAND,biped.toolR, null)
                                .addProperty(AnimationProperty.AttackPhaseProperty.MAX_STRIKES_MODIFIER,ValueModifier.setter(1F))
                                .addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.setter(-90F))
                                .addProperty(AnimationProperty.AttackPhaseProperty.IMPACT_MODIFIER,ValueModifier.adder(10F))
                               ,
                        new AttackAnimation.Phase(0.933F, 1.533F, 1.667F,  2.167F, 2.167F, InteractionHand.MAIN_HAND,biped.toolR, null)
                                .addProperty(AnimationProperty.AttackPhaseProperty.MAX_STRIKES_MODIFIER,ValueModifier.setter(1F))
                                .addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.adder(200F))
                                .addProperty(AnimationProperty.AttackPhaseProperty.IMPACT_MODIFIER,ValueModifier.adder(100F))
                        )

                        .addProperty(AnimationProperty.AttackAnimationProperty.ATTACK_SPEED_FACTOR, 1F)
                        .addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, 1F)
                        .addState(EntityState.MOVEMENT_LOCKED, true)
                        .newTimePair(0, 2.167F)
                        .addState(EntityState.TURNING_LOCKED, true)
                        .addEvents(AnimationEvent.TimePeriodEvent.create(0.733F, 2F, (livingEntityPatch, staticAnimation, objects) -> {
                                if (livingEntityPatch instanceof ServerPlayerPatch playerPatch) {
                                        // 给自己添加减伤效果，假设我们使用"伤害减免"的效果
                                        playerPatch.getOriginal().addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 100, 0)); // 100 ticks（5秒）伤害减免
                                        playerPatch.getOriginal().addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 100, -100)); // 禁用玩家的移动
                                        playerPatch.getOriginal().addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, 100, -100)); // 禁用玩家的挖掘速度
                                        playerPatch.getOriginal().addEffect(new MobEffectInstance(MobEffects.HEALTH_BOOST, 100, 0)); // 可选择增加生命值，增强生存能力

                                }
                        }, AnimationEvent.Side.SERVER));


                LIONCLAW_DUAL2 = new BasicAttackAnimation( 0.1F, "biped/skill/lionclaw_dual_2", biped,
                        new AttackAnimation.Phase(0F, 0.5F,  0.667F, 0F, 0.667F, InteractionHand.MAIN_HAND,biped.toolR, null)
                                .addProperty(AnimationProperty.AttackPhaseProperty.MAX_STRIKES_MODIFIER,ValueModifier.setter(1F))
                                .addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.setter(-80F))//伤害加成
                                .addProperty(AnimationProperty.AttackPhaseProperty.IMPACT_MODIFIER,ValueModifier.adder(30F))//冲击加成
                        ,
                        new AttackAnimation.Phase(0.933F, 1.533F, 1.667F,  2.167F, 2.167F, InteractionHand.MAIN_HAND,biped.toolR, null)
                                .addProperty(AnimationProperty.AttackPhaseProperty.MAX_STRIKES_MODIFIER,ValueModifier.setter(1F))
                                .addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.adder(150F))
                                .addProperty(AnimationProperty.AttackPhaseProperty.IMPACT_MODIFIER,ValueModifier.adder(100F))
                        )

                        .addProperty(AnimationProperty.AttackAnimationProperty.ATTACK_SPEED_FACTOR, 1F)
                        .addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, 1F)
                        .addState(EntityState.MOVEMENT_LOCKED, true)
                        .newTimePair(0, 2.167F)
                        .addState(EntityState.TURNING_LOCKED, true)

                        //.addState(EntityState.INTERRUPTION_LOCKED, true) // 锁定中断
                        .addEvents(AnimationEvent.TimePeriodEvent.create(0.5F, 0.667F, (livingEntityPatch, staticAnimation, objects) -> {
                                if (livingEntityPatch instanceof ServerPlayerPatch playerPatch) {
                                        // 给自己添加减伤效果，假设我们使用"伤害减免"的效果
                                         playerPatch.getOriginal().addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 100, 0)); // 100 ticks（5秒）伤害减免

                                        // 使用 Optional 来提取 StunType
                                        StunType stunType = staticAnimation.getProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE).orElse(StunType.NONE);  // 如果为空，默认使用 StunType.NONE
                                        // 根据 stunType 进行判断
                                        if (stunType == StunType.HOLD) {

                                        }
                                        else if (stunType == StunType.NONE) {
                                                // 如果没有眩晕效果，执行默认行为
                                        }

                                }
                        }, AnimationEvent.Side.SERVER))
                       ;



                //大剑bigsword
                BIGSWORD_CLAYMORE_AUTO1 = new BasicAttackAnimation(0.3F, 0.3F, 0.467F, 0.6F, null, biped.toolR,
                        "biped/bigsword/claymore_auto1", biped)
                        .addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, 0.9F)
                        .addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER,((dynamicAnimation, livingEntityPatch, v, v1) -> 1.0F))
                       // .addEvents(AnimationEvent.TimeStampedEvent
                           //     .create(0.5F, Animations.ReusableSources.FRACTURE_GROUND_SIMPLE, AnimationEvent.Side.CLIENT)
                         //       .params(new Vec3f(0.0F, -0.24F, -2.0F),yesman.epicfight.gameasset.Armatures.BIPED.rootJoint,1.0D, 0.55F))
                ;
                BIGSWORD_CLAYMORE_AUTO2 = new BasicAttackAnimation(0F, 0.567F, 0.867F, 1F, null, biped.toolR,
                        "biped/bigsword/claymore_auto2", biped)
                        .addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, 0.9F)
                        .addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER,((dynamicAnimation, livingEntityPatch, v, v1) -> 1.0F));
                BIGSWORD_CLAYMORE_AUTO3 = new BasicAttackAnimation(0F, 0.5F, 0.633F, 0.833F, null, biped.toolR,
                        "biped/bigsword/claymore_auto3", biped)
                        .addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, 0.9F)
                        .addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER,((dynamicAnimation, livingEntityPatch, v, v1) -> 1.0F))
                      //  .addEvents(AnimationEvent.TimeStampedEvent
                        //        .create(0.6F, Animations.ReusableSources.FRACTURE_GROUND_SIMPLE, AnimationEvent.Side.CLIENT)
                        //        .params(new Vec3f(0.0F, -0.24F, -2.0F),yesman.epicfight.gameasset.Armatures.BIPED.rootJoint,1.0D, 0.55F))
                  ;
                BIGSWORD_CLAYMORE_AUTO4 = new BasicAttackAnimation(0F, 0.67F, 0.9F, 1.167F, null, biped.toolR,
                        "biped/bigsword/claymore_auto4", biped)
                        .addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, 0.9F)
                        .addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER,((dynamicAnimation, livingEntityPatch, v, v1) -> 1.0F))
                       // .addEvents(AnimationEvent.TimeStampedEvent
                         //       .create(0.77F, Animations.ReusableSources.FRACTURE_GROUND_SIMPLE, AnimationEvent.Side.CLIENT)
                         //       .params(new Vec3f(0.0F, -0.24F, -2.0F),yesman.epicfight.gameasset.Armatures.BIPED.rootJoint,1.1D, 0.55F))
                     ;

                BIGSWORD_CLAYMORE_DASH = new DashAttackAnimation(0.1F, 0.667F, 0.6F, 0.8F, 1.333F, null, biped.toolR,
                        "biped/bigsword/claymore_dash", biped)
                        .addProperty(AnimationProperty.ActionAnimationProperty.STOP_MOVEMENT, true)
                        .addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER,
                                Animations.ReusableSources.CONSTANT_ONE);

                BIGSWORD_CLAYMORE_SKILL1 = new BasicAttackAnimation(0.5F, 0.833F, 1.067F, 1.8F, null, biped.toolR,
                        "biped/bigsword/claymore_heavy1", biped)
                        .addProperty(AnimationProperty.AttackAnimationProperty.ATTACK_SPEED_FACTOR, 0.9F)
                        .addState(EntityState.MOVEMENT_LOCKED, true)
                        .addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER,((dynamicAnimation, livingEntityPatch, v, v1) -> 1.2F));

                BIGSWORD_DUAL_CLAYMORE_AUTO1 = new BasicAttackAnimation(0.1F, "biped/bigsword/dual_claymore_auto1", biped,
                        new AttackAnimation.Phase(0F, 0.333F, 0.467F, 0F, 0.467F, InteractionHand.OFF_HAND,
                                biped.toolR, null),
                        new AttackAnimation.Phase(0F, 0.8F, 0.9F, 1.2F, 1.2F, InteractionHand.MAIN_HAND,
                                biped.toolR, null))
                        .addState(EntityState.MOVEMENT_LOCKED, true)
                        .addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER,((dynamicAnimation, livingEntityPatch, v, v1) -> 1.0F));
                BIGSWORD_DUAL_CLAYMORE_AUTO2 = new BasicAttackAnimation(0.1F, "biped/bigsword/dual_claymore_auto2", biped,
                        new AttackAnimation.Phase(0F, 0.6F, 0.767F, 0F, 0.767F, InteractionHand.OFF_HAND,
                                biped.toolR, null),
                        new AttackAnimation.Phase(0F, 0.867F, 1.0F, 1.333F, 1.333F, InteractionHand.MAIN_HAND,
                                biped.toolR, null))
                        .addState(EntityState.MOVEMENT_LOCKED, true)
                        .addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER,((dynamicAnimation, livingEntityPatch, v, v1) -> 1.0F));
                BIGSWORD_DUAL_CLAYMORE_AUTO3 = new BasicAttackAnimation(0.1F, "biped/bigsword/dual_claymore_auto3", biped,
                        new AttackAnimation.Phase(0F, 0.667F, 1.0F, 0F, 1.0F, InteractionHand.OFF_HAND,
                                biped.toolR, null),
                        new AttackAnimation.Phase(0F, 1.03F, 1.2F, 1.667F, 1.667F, InteractionHand.MAIN_HAND,
                                biped.toolR, null))
                        .addState(EntityState.MOVEMENT_LOCKED, true)
                        .addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER,((dynamicAnimation, livingEntityPatch, v, v1) -> 1.0F));

                BIGSWORD_DUAL_GREATWEAPON_IDLE = new StaticAnimation(true, "biped/bigsword/dual_greatweapon_idle", biped);
                BIGSWORD_DUAL_GREATWEAPON_WALK = new MovementAnimation(true, "biped/bigsword/dual_greatweapon_walk", biped);
                BIGSWORD_DUAL_GREATWEAPON_RUN = new MovementAnimation(true, "biped/bigsword/dual_greatweapon_run", biped);

                BIGSWORD_GREATWEAPON_IDLE = new StaticAnimation(true, "biped/bigsword/greatweapon_idle", biped);
                BIGSWORD_GREATWEAPON_WALK = new MovementAnimation(true, "biped/bigsword/greatweapon_walk", biped);
                BIGSWORD_GREATWEAPON_RUN = new MovementAnimation(true, "biped/bigsword/greatweapon_run", biped);



                //匕首dagger
                SHORTKNIFE_AUTO1 = new BasicAttackAnimation(0.05F, 0.133F, 0.233F, 0.234F, null, biped.toolR,
                        "biped/dagger/shortknife_auto1", biped)
                        .addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, 0.9F);
                SHORTKNIFE_AUTO2 = new BasicAttackAnimation(0.05F, 0.233F, 0.3F, 0.31F, null, biped.toolR,
                        "biped/dagger/shortknife_auto2", biped)
                        .addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, 0.9F);
                SHORTKNIFE_AUTO3 = new BasicAttackAnimation(0.05F, 0.3F, 0.434F, 0.435F, null, biped.toolR,
                        "biped/dagger/shortknife_auto3", biped)
                        .addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, 0.9F);
                SHORTKNIFE_AUTO4 = new BasicAttackAnimation(0.05F, 0.267F, 0.4F, 0.41F, null, biped.toolR,
                        "biped/dagger/shortknife_auto4", biped)
                        .addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, 0.9F);
                SHORTKNIFE_AUTO5 = new BasicAttackAnimation(0.05F, 0.3F, 0.4F, 0.41F, null, biped.toolR,
                        "biped/dagger/shortknife_auto5", biped)
                        .addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, 0.9F);
                SHORTKNIFE_AUTO6 = new BasicAttackAnimation(0.05F, 0.467F, 0.567F, 0.568F, null, biped.toolR,
                        "biped/dagger/shortknife_auto6", biped)
                        .addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, 0.9F);

                /// effect give @s minecraft:resistance infinite 4 true 无敌
                DUAL_SHORTKNIFE_AUTO1 = new BasicAttackAnimation(0.1F, "biped/dagger/dual_shortknife_auto1", biped,
                        new AttackAnimation.Phase(0F, 0.1F, 0.2F, 0.3F, 0.3F, InteractionHand.OFF_HAND,
                                biped.toolR, null),
                        new AttackAnimation.Phase(0.2F, 0.333F, 0.433F, 0.533F, 0.533F, InteractionHand.OFF_HAND,
                                biped.toolR, null),
                        new AttackAnimation.Phase(0.433F, 0.6F, 0.667F, 0.767F, 0.767F, InteractionHand.MAIN_HAND,
                                biped.toolR, null)).addState(EntityState.MOVEMENT_LOCKED, true)
                        .addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER,((dynamicAnimation, livingEntityPatch, v, v1) -> 1.7F));
                DUAL_SHORTKNIFE_AUTO2 = new BasicAttackAnimation(0.1F, "biped/dagger/dual_shortknife_auto2", biped,
                        new AttackAnimation.Phase(0F, 0.167F, 0.267F, 0.367F, 0.367F, InteractionHand.MAIN_HAND,
                                biped.toolR, null),
                        new AttackAnimation.Phase(0.267F, 0.367F, 0.5F, 0.6F, 0.6F, InteractionHand.MAIN_HAND,
                                biped.toolR, null),
                        new AttackAnimation.Phase(0.5F, 0.667F, 0.767F, 0.867F, 0.867F, InteractionHand.OFF_HAND,
                                biped.toolR, null)).addState(EntityState.MOVEMENT_LOCKED, true)
                        .addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER,((dynamicAnimation, livingEntityPatch, v, v1) -> 1.7F));
             //   indestructible @s play "theforcelawtweaks:biped/bigsword/claymore_dash" 1 0
                DUAL_SHORTKNIFE_AUTO3 = new BasicAttackAnimation(0.1F, "biped/dagger/dual_shortknife_auto3", biped,
                        new AttackAnimation.Phase(0F, 0.333F, 0.433F, 0.533F, 0.533F, InteractionHand.MAIN_HAND,
                                biped.toolR, null),
                        new AttackAnimation.Phase(0.433F, 0.4F, 0.533F, 0.633F, 0.633F, InteractionHand.OFF_HAND,
                                biped.toolR, null)).addState(EntityState.MOVEMENT_LOCKED, true)
                        .addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER,((dynamicAnimation, livingEntityPatch, v, v1) -> 1.7F));
                DUAL_SHORTKNIFE_AUTO4 = new BasicAttackAnimation(0.1F, "biped/dagger/dual_shortknife_auto4", biped,
                        new AttackAnimation.Phase(0F, 0.167F, 0.3F, 0.4F, 0.4F, InteractionHand.MAIN_HAND,
                                biped.toolR, null),
                        new AttackAnimation.Phase(0.3F, 0.4F, 0.467F, 0.567F, 0.567F, InteractionHand.OFF_HAND,
                                biped.toolR, null)).addState(EntityState.MOVEMENT_LOCKED, true)
                        .addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER,((dynamicAnimation, livingEntityPatch, v, v1) -> 1.7F));


//                DUAL_SHORTKNIFE_AUTO4 = new BasicAttackAnimation(0.05F, 0.433F, 0.55F, 0.833F, null, biped.toolR,
//                        "biped/dagger/dual_shortknife_auto4", biped)
//                        .addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, 0.9F);


                // one hand更新
                SKILL_ROLL_FRONT = new DodgeAnimation(0.08F, 0.6F, "biped/skill/roll_front", 0.6F, 1.65F, biped)
                                .addProperty(AnimationProperty.ActionAnimationProperty.STOP_MOVEMENT, true)
                                .newTimePair(0.667F, Float.MAX_VALUE)
                                .addState(EntityState.CAN_SKILL_EXECUTION, true)
                                .newTimePair(0F, 0.6F)
                                .addStateRemoveOld(EntityState.ATTACK_RESULT, DODGEABLE_SOURCE_VALIDATOR)
                                .newTimePair(0.0F, 1.0F)
                                .addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER,
                                                ((dynamicAnimation, livingEntityPatch, v1, v2) -> 1.2F))
                                .addStateRemoveOld(EntityState.CAN_BASIC_ATTACK, false);
                SKILL_ROLL_AFTER = new DodgeAnimation(0.08F, 0.6F, "biped/skill/roll_after", 0.6F, 1.65F, biped)
                                .addProperty(AnimationProperty.ActionAnimationProperty.STOP_MOVEMENT, true)
                                .newTimePair(0F, 0.6F)
                                .addStateRemoveOld(EntityState.ATTACK_RESULT, DODGEABLE_SOURCE_VALIDATOR)
                                .newTimePair(0.667F, Float.MAX_VALUE)
                                .addState(EntityState.CAN_SKILL_EXECUTION, true)
                                .newTimePair(0.0F, 1.0F)
                                .addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER,
                                                ((dynamicAnimation, livingEntityPatch, v1, v2) -> 1.2F))
                                .addStateRemoveOld(EntityState.CAN_BASIC_ATTACK, false);
                SKILL_ROLL_LEFT = new DodgeAnimation(0.08F, 0.6F, "biped/skill/roll_left", 0.6F, 1.65F, biped)
                                .addProperty(AnimationProperty.ActionAnimationProperty.STOP_MOVEMENT, true)
                                .newTimePair(0F, 0.6F)
                                .addStateRemoveOld(EntityState.ATTACK_RESULT, DODGEABLE_SOURCE_VALIDATOR)
                                .newTimePair(0.667F, Float.MAX_VALUE)
                                .addState(EntityState.CAN_SKILL_EXECUTION, true)
                                .newTimePair(0.0F, 1.0F)
                                .addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER,
                                                ((dynamicAnimation, livingEntityPatch, v1, v2) -> 1.2F))
                                .addStateRemoveOld(EntityState.CAN_BASIC_ATTACK, false);
                SKILL_ROLL_RIGHT = new DodgeAnimation(0.08F, 0.6F, "biped/skill/roll_right", 0.6F, 1.65F, biped)
                                .addProperty(AnimationProperty.ActionAnimationProperty.STOP_MOVEMENT, true)
                                .newTimePair(0F, 0.6F)
                                .addStateRemoveOld(EntityState.ATTACK_RESULT, DODGEABLE_SOURCE_VALIDATOR)
                                .newTimePair(0.3F, Float.MAX_VALUE)
                                .addState(EntityState.CAN_SKILL_EXECUTION, true)
                                .newTimePair(0.0F, 1.0F)
                                .addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER,
                                                ((dynamicAnimation, livingEntityPatch, v1, v2) -> 1.2F))
                                .addStateRemoveOld(EntityState.CAN_BASIC_ATTACK, false);

                SKILL_DODGE_FRONT = new DodgeAnimation(0.1F, 0.5f, "biped/skill/slidingstep_front", 0.6F, 1.65F,
                                biped)
                                .addProperty(AnimationProperty.ActionAnimationProperty.STOP_MOVEMENT, true)
                                .newTimePair(0F, 0.3F)
                                .addStateRemoveOld(EntityState.ATTACK_RESULT, DODGEABLE_SOURCE_VALIDATOR)
                                .newTimePair(0.0F, 0.667F)
                                .addState(EntityState.CAN_SKILL_EXECUTION, true)
                                .newTimePair(0.0F, 1.0F)
                                .addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER,
                                                ((dynamicAnimation, livingEntityPatch, v1, v2) -> 1.1F))
                                .addStateRemoveOld(EntityState.CAN_BASIC_ATTACK, false);
                SKILL_DODGE_AFTER = new DodgeAnimation(0.1F, 0.5f, "biped/skill/slidingstep_after", 0.6F, 1.65F,
                                biped)
                                .addProperty(AnimationProperty.ActionAnimationProperty.STOP_MOVEMENT, true)
                                .newTimePair(0F, 0.3F)
                                .addStateRemoveOld(EntityState.ATTACK_RESULT, DODGEABLE_SOURCE_VALIDATOR)
                                .newTimePair(0.0F, 0.667F)
                                .addState(EntityState.CAN_SKILL_EXECUTION, true)
                                .newTimePair(0.0F, 1.0F)
                                .addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER,
                                                ((dynamicAnimation, livingEntityPatch, v1, v2) -> 1.1F))
                                .addStateRemoveOld(EntityState.CAN_BASIC_ATTACK, false);
                SKILL_DODGE_LEFT = new DodgeAnimation(0.1F, 0.5f, "biped/skill/slidingstep_left", 0.6F, 1.65F, biped)
                                .addProperty(AnimationProperty.ActionAnimationProperty.STOP_MOVEMENT, true)
                                .newTimePair(0F, 0.3F)
                                .addStateRemoveOld(EntityState.ATTACK_RESULT, DODGEABLE_SOURCE_VALIDATOR)
                                .newTimePair(0.0F, 0.667F)
                                .addState(EntityState.CAN_SKILL_EXECUTION, true)
                                .newTimePair(0.0F, 1.0F)
                                .addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER,
                                                ((dynamicAnimation, livingEntityPatch, v1, v2) -> 1.1F))
                                .addStateRemoveOld(EntityState.CAN_BASIC_ATTACK, false);
                SKILL_DODGE_RIGHT = new DodgeAnimation(0.1F, 0.5f, "biped/skill/slidingstep_right", 0.6F, 1.65F, biped)
                                .addProperty(AnimationProperty.ActionAnimationProperty.STOP_MOVEMENT, true)
                                .newTimePair(0F, 0.3F)
                                .addStateRemoveOld(EntityState.ATTACK_RESULT, DODGEABLE_SOURCE_VALIDATOR)
                                .newTimePair(0.0F, 0.667F)
                                .addState(EntityState.CAN_SKILL_EXECUTION, true)
                                .newTimePair(0.0F, 1.0F)
                                .addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER,
                                                ((dynamicAnimation, livingEntityPatch, v1, v2) -> 1.1F))
                                .addStateRemoveOld(EntityState.CAN_BASIC_ATTACK, false);

                /// indestructible @s play "theforcelawtweaks:biped/dagger/dual_shortknife_auto2" 1 0
                /// 0修gx

                // yullian
                YULLIAN_COMBOA1 = new BasicAttackAnimation(0.1F, 0.8F, 0.93F, 1F, null, biped.toolR,
                                "biped/yullian/yullian_comboa1", biped);
                YULLIAN_COMBOA2 = new BasicAttackAnimation(0.1F, 0.7F, 0.8F, 0.85F, null, biped.toolR,
                                "biped/yullian/yullian_comboa2", biped);
                YULLIAN_COMBOA3 = new BasicAttackAnimation(0.1F, 0.467F, 0.6F, 2.43F, null, biped.toolR,
                                "biped/yullian/yullian_comboa3", biped);
                YULLIAN_COMBOB1 = new BasicAttackAnimation(0.1F, "biped/yullian/yullian_combob1", biped,
                                new AttackAnimation.Phase(0F, 0.63F, 0.76F, 3.23F, 0.76F, InteractionHand.MAIN_HAND,
                                                biped.toolR, null),
                                new AttackAnimation.Phase(0.76F, 1.36F, 1.53F, 3.23F, 3.23F, InteractionHand.MAIN_HAND,
                                                biped.toolR, null));

                YULLIAN_COMBOC1 = new BasicAttackAnimation(0.1F, 0.4F, 0.5F, 0.73F, null, biped.toolR,
                                "biped/yullian/yullian_comboc1", biped);

                YULLIAN_COMBOC2 = new BasicAttackAnimation(0.05F, "biped/yullian/yullian_comboc2", biped,
                                new AttackAnimation.Phase(0F, 0.5F, 0.9F, 0F, 0.9F, InteractionHand.MAIN_HAND,
                                                biped.toolR, null),
                                new AttackAnimation.Phase(0.9F, 0.9F, 1.1F, 1F, 233F, InteractionHand.MAIN_HAND,
                                                biped.toolR, null));

                YULLIAN_DODGEATTACK = new BasicAttackAnimation(0.1F, 0.26F, 0.83F, 2.667F, null, biped.toolR,
                                "biped/yullian/yullian_dodgeattack", biped);

                YULLIAN_JUMP_HEAVYATTACK = new BasicAttackAnimation(0.1F, 0.967F, 1.06F, 4.267F, null, biped.toolR,
                                "biped/yullian/yullian_jump_heavyattack", biped);

                YULLIAN_JUMPPATTACK = new BasicAttackAnimation(0.1F, 0.67F, 0.76F, 2.83F, null, biped.toolR,
                                "biped/yullian/yullian_jumpattack", biped);
                YULLIAN_DASHAHATTCK = new BasicAttackAnimation(0.1F, 1.5F, 1.9F, 2.83F, null, biped.toolR,
                                "biped/yullian/yullian_dashattack", biped);

                YULLIAN_SPECIALATTACK1 = new BasicAttackAnimation(0.1F, 1.43F, 1.8F, 4.2F, null, biped.toolR,
                                "biped/yullian/yullian_specialattack1", biped);
                YULLIAN_SPECIALATTACK2 = new BasicAttackAnimation(0.1F, 1.23F, 1.56F, 4.167F, null, biped.toolR,
                                "biped/yullian/yullian_specialattack2", biped);
                YULLIAN_SPECIALATTACK3 = new BasicAttackAnimation(0.1F, 1.567F, 2.0F, 3.8F, null, biped.toolR,
                                "biped/yullian/yullian_specialattack3", biped);
                YULLIAN_WALK = new StaticAnimation(true, "biped/yullian/yullian_walk", biped);
                YULLIAN_RUN = new StaticAnimation(true, "biped/yullian/yullian_run", biped);
                YULLIAN_IDLE = new StaticAnimation(true, "biped/yullian/yullian_idle", biped);

                /// indestructible @s play "theforcelawtweaks:biped/combat/handhalfsword_auto1" 0 0
                HANDHALFSWORD_AUTO1 = new BasicAttackAnimation(0.1F, 0.46F, 0.56F, 0.58F, null, biped.toolR,
                                "biped/combat/handhalfsword_auto1", biped)
                                .addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, 1.6F)
                                .addProperty(AnimationProperty.AttackPhaseProperty.IMPACT_MODIFIER,
                                                ValueModifier.multiplier(1.1F));

                HANDHALFSWORD_AUTO2 = new BasicAttackAnimation(0.05F, 0.4F, 0.6F, 0.67F, null, biped.toolR,
                                "biped/combat/handhalfsword_auto2", biped)
                                .addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, 1.6F);
                HANDHALFSWORD_AUTO3 = new BasicAttackAnimation(0.05F, 0.4F, 0.6F, 0.67F, null, biped.toolR,
                                "biped/combat/handhalfsword_auto3", biped)
                                .addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, 1.6F);
                HANDHALFSWORD_AUTO4 = new BasicAttackAnimation(0.05F, 0.37F, 0.53F, 0.67F, null, biped.toolR,
                                "biped/combat/handhalfsword_auto4", biped)
                                .addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, 1.6F);
                HANDHALFSWORD_AUTO5 = new BasicAttackAnimation(0.05F, 0.53F, 0.76F, 0.86F, null, biped.toolR,
                                "biped/combat/handhalfsword_auto5", biped)
                                .addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, 1.6F)
                                .addProperty(AnimationProperty.AttackPhaseProperty.IMPACT_MODIFIER,
                                                ValueModifier.multiplier(1.2F))
                                .addEvents(AnimationEvent.TimeStampedEvent.create(0.0F,
                                                (entitypatch, animation, params) -> {
                                                        if (entitypatch instanceof ServerPlayerPatch playerPatch) {
                                                                BasicAttack.setComboCounterWithEvent(
                                                                                ComboCounterHandleEvent.Causal.TIME_EXPIRED_RESET,
                                                                                playerPatch,
                                                                                playerPatch.getSkill(
                                                                                                SkillSlots.BASIC_ATTACK),
                                                                                null, 1);
                                                        }
                                                }, AnimationEvent.Side.SERVER));
                HANDHALFSWORD_DASH = new DashAttackAnimation(0.1F, 0.53F, 0.54F, 0.73F, 1.26F, null, biped.toolR,
                                "biped/combat/handhalfsword_dash", biped)
                                .addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, 1.6F)
                                .addProperty(AnimationProperty.AttackPhaseProperty.IMPACT_MODIFIER,
                                                ValueModifier.multiplier(1.2F))
                                .addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER,
                                                ValueModifier.multiplier(1.1F));
                HANDHALFSWORD_AIRSLASH = new AirSlashAnimation(0.22F, 0.53F, 0.73F, 1.26F, null, biped.toolR,
                                "biped/combat/handhalfsword_airslash", biped)
                                .addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, 1.6F)
                                .addProperty(AnimationProperty.AttackPhaseProperty.IMPACT_MODIFIER,
                                                ValueModifier.multiplier(1.3F))
                                .addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER,
                                                ValueModifier.multiplier(1.2F))
                                .addProperty(AnimationProperty.ActionAnimationProperty.MOVE_VERTICAL, false);

                HANDHALFSWORD_DODGE_ATTACK1 = new TFLDodgeAttackAnimation(0.15F, 0.133F, 0.133F, 0.3F, 1F,
                                InteractionHand.MAIN_HAND, null, biped.toolR,
                                "biped/combat/handhalfsword_dodge_attack_1", biped)
                                .addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, 1.6F)
                                .addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER,
                                                ValueModifier.multiplier(0.8F))
                                .addEvents(AnimationEvent.TimePeriodEvent.create(1F, 2.0F, PURSUIT_EVENT,
                                                AnimationEvent.Side.CLIENT))
                                .newTimePair(1F, Float.MAX_VALUE)
                                .addStateRemoveOld(EntityState.CAN_SKILL_EXECUTION, true)
                                .addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER,
                                                ((dynamicAnimation, livingEntityPatch, v, v1) -> 1.5F));

                HANDHALFSWORD_DODGE_ATTACK1_L = new TFLDodgeAttackAnimation(0.15F, 0.133F, 0.133F, 0.3F, 1F,
                                InteractionHand.MAIN_HAND, null, biped.toolR,
                                "biped/combat/handhalfsword_dodge_attack_1_left", biped)
                                .addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, 1.6F)
                                .addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER,
                                                ValueModifier.multiplier(0.8F))
                                .addEvents(AnimationEvent.TimePeriodEvent.create(0.5F, 2.0F, PURSUIT_EVENT,
                                                AnimationEvent.Side.CLIENT))
                                .newTimePair(1F, Float.MAX_VALUE)
                                .addStateRemoveOld(EntityState.CAN_SKILL_EXECUTION, true)
                                .addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER,
                                                ((dynamicAnimation, livingEntityPatch, v, v1) -> 1.5F));

                HANDHALFSWORD_DODGE_ATTACK1_R = new TFLDodgeAttackAnimation(0.15F, 0.133F, 0.133F, 0.3F, 1F,
                                InteractionHand.MAIN_HAND, null, biped.toolR,
                                "biped/combat/handhalfsword_dodge_attack_1_right", biped)
                                .addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, 1.6F)
                                .addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER,
                                                ValueModifier.multiplier(0.8F))
                                .addEvents(AnimationEvent.TimePeriodEvent.create(0.5F, 2.0F, PURSUIT_EVENT,
                                                AnimationEvent.Side.CLIENT))
                                .newTimePair(1F, Float.MAX_VALUE)
                                .addStateRemoveOld(EntityState.CAN_SKILL_EXECUTION, true)
                                .addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER,
                                                ((dynamicAnimation, livingEntityPatch, v, v1) -> 1.5F));

                HANDHALFSWORD_DODGE_ATTACK2 = new TFLDodgeAttackAnimation(0.15F, 0.067F, 0.067F, 0.2F, 1F,
                                InteractionHand.MAIN_HAND, null, biped.toolR,
                                "biped/combat/handhalfsword_dodge_attack_2", biped)
                                .addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, 1.6F)
                                .addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER,
                                                ValueModifier.multiplier(0.8F))
                                .addEvents(AnimationEvent.TimePeriodEvent.create(0.5F, 2.0F, PURSUIT_EVENT,
                                                AnimationEvent.Side.CLIENT))
                                .newTimePair(1F, Float.MAX_VALUE)
                                .addStateRemoveOld(EntityState.CAN_SKILL_EXECUTION, true)
                                .addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER,
                                                ((dynamicAnimation, livingEntityPatch, v, v1) -> 1.5F));

                HANDHALFSWORD_DODGE_ATTACK2_L = new TFLDodgeAttackAnimation(0.15F, 0.067F, 0.067F, 0.2F, 1F,
                                InteractionHand.MAIN_HAND, null, biped.toolR,
                                "biped/combat/handhalfsword_dodge_attack_2_left", biped)
                                .addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, 1.6F)
                                .addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER,
                                                ValueModifier.multiplier(0.8F))
                                .addEvents(AnimationEvent.TimePeriodEvent.create(0.5F, 2.0F, PURSUIT_EVENT,
                                                AnimationEvent.Side.CLIENT))
                                .newTimePair(1F, Float.MAX_VALUE)
                                .addStateRemoveOld(EntityState.CAN_SKILL_EXECUTION, true)
                                .addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER,
                                                ((dynamicAnimation, livingEntityPatch, v, v1) -> 1.5F));

                HANDHALFSWORD_DODGE_ATTACK2_R = new TFLDodgeAttackAnimation(0.15F, 0.067F, 0.067F, 0.2F, 1F,
                                InteractionHand.MAIN_HAND, null, biped.toolR,
                                "biped/combat/handhalfsword_dodge_attack_2_right", biped)
                                .addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, 1.6F)
                                .addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER,
                                                ValueModifier.multiplier(0.8F))
                                .addEvents(AnimationEvent.TimePeriodEvent.create(0.5F, 2.0F, PURSUIT_EVENT,
                                                AnimationEvent.Side.CLIENT))
                                .newTimePair(1F, Float.MAX_VALUE)
                                .addStateRemoveOld(EntityState.CAN_SKILL_EXECUTION, true)
                                .addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER,
                                                ((dynamicAnimation, livingEntityPatch, v, v1) -> 1.5F));

                PURSUIT_LIGHT = new AttackAnimation(0.1F, 0.36F, 0.5F, 0.16F, 0.75F, InteractionHand.MAIN_HAND, null,
                                biped.toolR, "biped/combat/handhalfsword_dodge_pursuit_light", biped)
                                .addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, 1.6F)
                                .addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER,
                                                ValueModifier.multiplier(1.3F))
                                .addProperty(AnimationProperty.AttackPhaseProperty.IMPACT_MODIFIER,
                                                ValueModifier.multiplier(1.25F));

                PURSUIT_HEAVY = new AttackAnimation(0.1F, 0.56F, 0.57F, 0.67F, 1.20F, InteractionHand.MAIN_HAND, null,
                                biped.toolR, "biped/combat/handhalfsword_dodge_pursuit_heavy", biped)
                                .addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, 1.6F)
                                .addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER,
                                                ValueModifier.multiplier(1.6F))
                                .addProperty(AnimationProperty.AttackPhaseProperty.IMPACT_MODIFIER,
                                                ValueModifier.multiplier(1.5F));

                PURSUIT = new AttackAnimation(0.1F, 0.53F, 0.53F, 0.63F, 1.23F, InteractionHand.MAIN_HAND, null,
                                biped.toolR, "biped/combat/handhalfsword_dodge_pursuit", biped)
                                .addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, 1.6F)
                                .addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER,
                                                ValueModifier.multiplier(1.6F))
                                .addProperty(AnimationProperty.AttackPhaseProperty.IMPACT_MODIFIER,
                                                ValueModifier.multiplier(1.5F))
                                .addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER,
                                                ((dynamicAnimation, livingEntityPatch, v, v1) -> 0.9F));

                HANDHALFSWORD_HEAVY_ATTACK1 = new AttackAnimation(0.5F, 0.6F, 0.61F, 1.05F, 1.5F,
                                InteractionHand.MAIN_HAND, null, biped.toolR,
                                "biped/combat/handhalfsword_heavyattack_1", biped)
                                .addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, 1.5F)
                                .addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER,
                                                ValueModifier.multiplier(1.75F))
                                .newTimePair(1.5F, Float.MAX_VALUE)
                                .addStateRemoveOld(EntityState.CAN_SKILL_EXECUTION, true)
                                .addEvents(AnimationEvent.TimePeriodEvent.create(0.01F, 0.54F,
                                                ((livingEntityPatch, staticAnimation, objects) -> {
                                                        // if (EpicFightKeyMappings.DODGE.isDown() &&
                                                        // Minecraft.getInstance().player != null) {
                                                        // if (TFLKeyMappings.A.isDown()) {
                                                        // livingEntityPatch.playAnimationSynchronized(HANDHALFSWORD_DODGE_ATTACK1_L,
                                                        // 0.0F);
                                                        // } else if(TFLKeyMappings.D.isDown()){
                                                        // livingEntityPatch.playAnimationSynchronized(HANDHALFSWORD_DODGE_ATTACK1_R,
                                                        // 0.0F);
                                                        // } else {
                                                        // livingEntityPatch.playAnimationSynchronized(HANDHALFSWORD_DODGE_ATTACK1,
                                                        // 0.0F);
                                                        // }
                                                        // }
                                                        if (TFLKeyMappings.D.isDown()
                                                                        && EpicFightKeyMappings.DODGE.isDown()) {
                                                                livingEntityPatch.playAnimationSynchronized(
                                                                                HANDHALFSWORD_DODGE_ATTACK1_R, 0.0F);
                                                        } else if (TFLKeyMappings.A.isDown()
                                                                        && EpicFightKeyMappings.DODGE.isDown()) {
                                                                livingEntityPatch.playAnimationSynchronized(
                                                                                HANDHALFSWORD_DODGE_ATTACK1_L, 0.0F);
                                                        } else if (EpicFightKeyMappings.DODGE.isDown()) {
                                                                livingEntityPatch.playAnimationSynchronized(
                                                                                HANDHALFSWORD_DODGE_ATTACK1, 0.0F);
                                                        }
                                                }), AnimationEvent.Side.CLIENT));
                HANDHALFSWORD_HEAVY_ATTACK2 = new AttackAnimation(0.5F, 0.6F, 0.61F, 1.0F, 1.5F,
                                InteractionHand.MAIN_HAND, null, biped.toolR,
                                "biped/combat/handhalfsword_heavyattack_2", biped)
                                .addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, 1.5F)
                                .addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER,
                                                ValueModifier.multiplier(1.75F))
                                .addEvents(AnimationEvent.TimePeriodEvent.create(0.01F, 0.61F,
                                                ((livingEntityPatch, staticAnimation, objects) -> {
                                                        if (TFLKeyMappings.D.isDown()
                                                                        && EpicFightKeyMappings.DODGE.isDown()) {
                                                                livingEntityPatch.playAnimationSynchronized(
                                                                                HANDHALFSWORD_DODGE_ATTACK2_R, 0.0F);
                                                        } else if (TFLKeyMappings.A.isDown()
                                                                        && EpicFightKeyMappings.DODGE.isDown()) {
                                                                livingEntityPatch.playAnimationSynchronized(
                                                                                HANDHALFSWORD_DODGE_ATTACK2_L, 0.0F);
                                                        } else if (EpicFightKeyMappings.DODGE.isDown()) {
                                                                livingEntityPatch.playAnimationSynchronized(
                                                                                HANDHALFSWORD_DODGE_ATTACK2, 0.0F);
                                                        }
                                                }), AnimationEvent.Side.CLIENT));

                // dual
                HANDHALFSWORD_DUAL_AUTO1 = new BasicAttackAnimation(0.1F, "biped/combat/handhalfsword_dual_auto1",
                                biped,
                                new AttackAnimation.Phase(0F, 0.4F, 0.41F, 0.67F, 0.80F, Float.MAX_VALUE, false,
                                                InteractionHand.MAIN_HAND,
                                                List.of(Pair.of(biped.toolR, null), Pair.of(biped.toolL, null))))
                                .addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, 1.6F)
                                .addProperty(AnimationProperty.AttackPhaseProperty.IMPACT_MODIFIER,
                                                ValueModifier.multiplier(1.1F));

                HANDHALFSWORD_DUAL_AUTO2 = new BasicAttackAnimation(0.05F, "biped/combat/handhalfsword_dual_auto2",
                                biped,
                                new AttackAnimation.Phase(0F, 0.3F, 0.31F, 0.43F, 0.5F, Float.MAX_VALUE, false,
                                                InteractionHand.MAIN_HAND,
                                                List.of(Pair.of(biped.toolR, null), Pair.of(biped.toolL, null))))
                                .addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, 1.6F);
                HANDHALFSWORD_DUAL_AUTO3 = new BasicAttackAnimation(0.05F, "biped/combat/handhalfsword_dual_auto3",
                                biped,
                                new AttackAnimation.Phase(0F, 0.6F, 0.61F, 0.73F, 0.83F, Float.MAX_VALUE, false,
                                                InteractionHand.MAIN_HAND,
                                                List.of(Pair.of(biped.toolR, null), Pair.of(biped.toolL, null))))
                                .addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, 1.6F);
                HANDHALFSWORD_DUAL_AUTO4 = new BasicAttackAnimation(0.05F, "biped/combat/handhalfsword_dual_auto4",
                                biped,
                                new AttackAnimation.Phase(0F, 0.33F, 0.34F, 0.57F, 0.73F, Float.MAX_VALUE, false,
                                                InteractionHand.MAIN_HAND,
                                                List.of(Pair.of(biped.toolR, null), Pair.of(biped.toolL, null))),
                                new AttackAnimation.Phase(0F, 0.43F, 0.45F, 0.7F, 0.8F, Float.MAX_VALUE, false,
                                                InteractionHand.OFF_HAND,
                                                List.of(Pair.of(biped.toolL, null), Pair.of(biped.toolL, null))))
                                .addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, 1.6F);
                HANDHALFSWORD_DUAL_AUTO5 = new BasicAttackAnimation(0.05F, "biped/combat/handhalfsword_dual_auto5",
                                biped,
                                new AttackAnimation.Phase(0F, 0.33F, 0.34F, 0.6F, 0.83F, Float.MAX_VALUE, false,
                                                InteractionHand.MAIN_HAND,
                                                List.of(Pair.of(biped.toolR, null), Pair.of(biped.toolL, null))))
                                .addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, 1.6F)
                                .addProperty(AnimationProperty.AttackPhaseProperty.IMPACT_MODIFIER,
                                                ValueModifier.multiplier(1.1F))
                                .addEvents(AnimationEvent.TimeStampedEvent.create(0.0F,
                                                (entitypatch, animation, params) -> {
                                                        if (entitypatch instanceof ServerPlayerPatch playerPatch) {
                                                                BasicAttack.setComboCounterWithEvent(
                                                                                ComboCounterHandleEvent.Causal.TIME_EXPIRED_RESET,
                                                                                playerPatch,
                                                                                playerPatch.getSkill(
                                                                                                SkillSlots.BASIC_ATTACK),
                                                                                null, 1);
                                                        }
                                                }, AnimationEvent.Side.SERVER));
                HANDHALFSWORD_DUAL_DASH = new DashAttackAnimation(0.1F, "biped/combat/handhalfsword_dual_dash", biped,
                                new AttackAnimation.Phase(0F, 0.6F, 0.61F, 1.67F, 2F, Float.MAX_VALUE, false,
                                                InteractionHand.MAIN_HAND,
                                                List.of(Pair.of(biped.toolR, null), Pair.of(biped.toolL, null))))
                                .addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, 1.6F)
                                .addProperty(AnimationProperty.AttackPhaseProperty.IMPACT_MODIFIER,
                                                ValueModifier.multiplier(1.2F))
                                .addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER,
                                                ValueModifier.multiplier(1.1F));
                HANDHALFSWORD_DUAL_AIRSLASH = new AirSlashAnimation(0F, 0.36F, 0.6F, 1.33F, null, biped.toolR,
                                "biped/combat/handhalfsword_dual_airslash", biped)
                                .addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, 1.6F)
                                .addProperty(AnimationProperty.AttackPhaseProperty.IMPACT_MODIFIER,
                                                ValueModifier.multiplier(1.3F))
                                .addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER,
                                                ValueModifier.multiplier(1.2F))
                                .addProperty(AnimationProperty.ActionAnimationProperty.NO_GRAVITY_TIME,
                                                TimePairList.create(0.0F, 1.33F));

                // Skill
                SQUAREOFF_ON = new ActionAnimation(0.05F, "biped/skill/squareoff_on", biped);
                SQUAREOFF_OFF = new ActionAnimation(0.05F, "biped/skill/squareoff_off", biped);
                SQUAREOFF_LOOP = new StaticAnimation(true, "biped/skill/squareoff_loop", biped);
                SQUAREOFF_WALK = new MovementAnimation(true, "biped/skill/squareoff_walk", biped);

                SQUAREOFF_BLOCKATTACK = new AttackAnimation(0.2F, 0.37F, 1.15F, 0.5F, 1.67F, ColliderPreset.SPEAR,
                                biped.toolR, "biped/skill/squareoff_blockattack", biped)
                                .addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, 1.0F)
                                .addProperty(AnimationProperty.AttackAnimationProperty.ATTACK_SPEED_FACTOR, 1.0F)
                                .addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER,
                                                ValueModifier.adder(0.55F))
                                .addProperty(AnimationProperty.AttackPhaseProperty.IMPACT_MODIFIER,
                                                ValueModifier.adder(0.5F));
                SQUAREOFF_HEAVY = new AttackAnimation(0.1F, 0.60F, 1.15F, 0.57F, 1.67F, ColliderPreset.SPEAR,
                                biped.toolR, "biped/skill/squareoff_heavy", biped)
                                .addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, 1.0F)
                                .addProperty(AnimationProperty.AttackAnimationProperty.ATTACK_SPEED_FACTOR, 0.5F)
                                .addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER,
                                                ValueModifier.adder(0.75F))
                                .addProperty(AnimationProperty.AttackPhaseProperty.IMPACT_MODIFIER,
                                                ValueModifier.adder(0.8F));
                SQUAREOFF_HIT = new ActionAnimation(0.05F, "biped/skill/squareoff_hit", biped);
                SQUAREOFF_LIGHT = new AttackAnimation(0.1F, 0.467F, 1.15F, 0.57F, 1F, ColliderPreset.SPEAR, biped.toolR,
                                "biped/skill/squareoff_light", biped)
                                .addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, 1.0F)
                                .addProperty(AnimationProperty.AttackAnimationProperty.ATTACK_SPEED_FACTOR, 0.5F)
                                .addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER,
                                                ValueModifier.adder(0.35F))
                                .addProperty(AnimationProperty.AttackPhaseProperty.IMPACT_MODIFIER,
                                                ValueModifier.adder(0.3F));

                // new
                WALK = new StaticAnimation(true, "biped/monster/walk", biped);
                IDEL0 = new StaticAnimation(true, "biped/monster/idle0", biped);
                IDEL1 = new StaticAnimation(true, "biped/monster/idle1", biped);
                RUN = new StaticAnimation(true, "biped/monster/run", biped);
                SHIELD = new MirrorAnimation(0.25F, true, "biped/monster/shield", "biped/monster/shield", biped);
                SHIELD_BOKEN = new LongHitAnimation(0.05F, "biped/monster/shield-broken", biped);
                SHIELD_HIT1 = new LongHitAnimation(0.05F, "biped/monster/shield-hit-1", biped);
                SHIELD_HIT2 = new LongHitAnimation(0.05F, "biped/monster/shield-hit-2", biped);
                SHIELD_HIT3 = new LongHitAnimation(0.05F, "biped/monster/shield-hit-3", biped);
                SHIELD_HIT4 = new LongHitAnimation(0.05F, "biped/monster/shield-hit-4", biped);

                SLASH_SHIELD = new AttackAnimation(0.1F, 1.967F, 1.15F, 2.216F, 5F, ColliderPreset.SPEAR,
                                biped.rootJoint, "biped/monster/slash-shield", biped)
                                .addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER,
                                                ValueModifier.multiplier(-0.2F))
                                .addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER,
                                                ValueModifier.adder(0.5F))
                                .addProperty(AnimationProperty.AttackAnimationProperty.FIXED_MOVE_DISTANCE, true)
                                .addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER,
                                                Animations.ReusableSources.CONSTANT_ONE);

                SLASH_SPEAR = new AttackAnimation(0.1F, 0.55F, 0.95F, 1.06F, 3F, null, biped.toolR,
                                "biped/monster/slash-spear", biped)
                                .addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER,
                                                ValueModifier.multiplier(-0.2F))
                                .addProperty(AnimationProperty.AttackPhaseProperty.IMPACT_MODIFIER,
                                                ValueModifier.multiplier(0.5F))
                                .addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER,
                                                Animations.ReusableSources.CONSTANT_ONE);

                SPEAR_SPECIAL = new AttackAnimation(0.1F, "biped/monster/spear-special", biped,
                                new AttackAnimation.Phase(0.0F, 1.25F, 1.416F, 1.42F, 1.42F, biped.toolR, null),
                                new AttackAnimation.Phase(0.4F, 1.95F, 2.116F, 2.22F, 2.5F, biped.toolR, null),
                                new AttackAnimation.Phase(0.6F, 2.591F, 2.758F, 5.16F, Float.MAX_VALUE, biped.toolR,
                                                null))
                                .addProperty(AnimationProperty.ActionAnimationProperty.STOP_MOVEMENT, true)
                                .addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER,
                                                Animations.ReusableSources.CONSTANT_ONE);

                SPEAR_SWEEP = new AttackAnimation(0.1F, 0.616F, 0.801F, 0.942F, 4.16F, null, biped.toolR,
                                "biped/monster/spear-sweep", biped)
                                .addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER,
                                                Animations.ReusableSources.CONSTANT_ONE);

                SPEAR_AUTO1 = new BasicAttackAnimation(0.1F, "biped/monster/spear-auto1", biped,
                                new AttackAnimation.Phase(0F, 0.975F, 0.55F, 1.15F, 2.708F, Float.MAX_VALUE,
                                                biped.toolR, null))
                                .addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER,
                                                Animations.ReusableSources.CONSTANT_ONE);
                SPEAR_AUTO2 = new BasicAttackAnimation(0.1F, "biped/monster/spear-auto2", biped,
                                new AttackAnimation.Phase(0F, 0.95F, 1.035F, 1.191F, 3.041F, Float.MAX_VALUE,
                                                biped.toolR, null))
                                .addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER,
                                                Animations.ReusableSources.CONSTANT_ONE);

                SPEAR_AUTO3 = new BasicAttackAnimation(0.1F, "biped/monster/spear-auto3", biped,
                                new AttackAnimation.Phase(0F, 0.967F, 1.0F, 1.191F, 7.291F, Float.MAX_VALUE,
                                                biped.toolR, null))
                                .addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER,
                                                Animations.ReusableSources.CONSTANT_ONE);

                COLOSSALSWORD_IDLE = new StaticAnimation(true, "biped/combat/colossalsword/colossalsword_idle", biped);
                COLOSSALSWORD_AUTO1 = new BasicAttackAnimation(0.1F, "biped/combat/colossalsword/greatsword1", biped,
                                new AttackAnimation.Phase(0F, 0.7F, 0.75F, 0.8F, 1.13F, Float.MAX_VALUE, biped.toolR,
                                                null))
                                .addProperty(AnimationProperty.AttackPhaseProperty.IMPACT_MODIFIER,
                                                ValueModifier.adder(0.1F))
                                .addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER,
                                                Animations.ReusableSources.CONSTANT_ONE)
                                .addEvents(AnimationEvent.TimeStampedEvent
                                                .create(0.95F, Animations.ReusableSources.FRACTURE_GROUND_SIMPLE, AnimationEvent.Side.CLIENT)
                                                .params(new Vec3f(0.0F, -0.24F, -2.0F),yesman.epicfight.gameasset.Armatures.BIPED.rootJoint,1.1D, 0.55F));
                COLOSSALSWORD_AUTO2 = new BasicAttackAnimation(0.1F, "biped/combat/colossalsword/greatsword2", biped,
                                new AttackAnimation.Phase(0F, 0.76F, 0.70F, 1.23F, 1.5F, Float.MAX_VALUE, biped.toolR,
                                                null))
                                .addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER,
                                                Animations.ReusableSources.CONSTANT_ONE)
                                .addEvents(AnimationEvent.TimeStampedEvent
                                                .create(1.25F, Animations.ReusableSources.FRACTURE_GROUND_SIMPLE,
                                                                AnimationEvent.Side.CLIENT)
                                                .params(new Vec3f(0.0F, -0.24F, -2.0F),
                                                                yesman.epicfight.gameasset.Armatures.BIPED.toolR, 1.1D,
                                                                0.55F));
                COLOSSALSWORD_AUTO3 = new BasicAttackAnimation(0.1F, "biped/combat/colossalsword/greatsword3", biped,
                                new AttackAnimation.Phase(0F, 0.67F, 0.70F, 0.75F, 1F, Float.MAX_VALUE, biped.toolR,
                                                null))
                                .addProperty(AnimationProperty.AttackPhaseProperty.IMPACT_MODIFIER,
                                                ValueModifier.adder(0.25F))
                                .addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER,
                                                Animations.ReusableSources.CONSTANT_ONE);
                COLOSSALSWORD_AUTO4 = new BasicAttackAnimation(0.1F, "biped/combat/colossalsword/greatsword4", biped,
                                new AttackAnimation.Phase(0F, 0.63F, 0.75F, 1.83F, 1.3F, Float.MAX_VALUE, biped.toolR,
                                                null))
                                .addProperty(AnimationProperty.AttackPhaseProperty.IMPACT_MODIFIER,
                                                ValueModifier.adder(0.5F))
                                .addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER,
                                                Animations.ReusableSources.CONSTANT_ONE)
                                .addEvents(AnimationEvent.TimeStampedEvent
                                                .create(0.95F, Animations.ReusableSources.FRACTURE_GROUND_SIMPLE,
                                                                AnimationEvent.Side.CLIENT)
                                                .params(new Vec3f(0.0F, -0.24F, -2.0F),
                                                                yesman.epicfight.gameasset.Armatures.BIPED.rootJoint,
                                                                1.1D, 0.55F));
                COLOSSALSWORD_AUTO5 = new BasicAttackAnimation(0.1F, "biped/combat/colossalsword/greatsword5", biped,
                                new AttackAnimation.Phase(0F, 0.7F, 0.75F, 1.13F, 1.43F, Float.MAX_VALUE, biped.toolR,
                                                null))
                                .addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER,
                                                Animations.ReusableSources.CONSTANT_ONE)
                                .addEvents(AnimationEvent.TimeStampedEvent
                                                .create(1.25F, Animations.ReusableSources.FRACTURE_GROUND_SIMPLE,
                                                                AnimationEvent.Side.CLIENT)
                                                .params(new Vec3f(0.0F, -0.24F, -2.0F),
                                                                yesman.epicfight.gameasset.Armatures.BIPED.toolR, 1.1D,
                                                                0.55F));
                EXECUTE = new BasicAttackWinAnimation(0.0F, 0.0F, 2.65F, 1.3F, 1.75F, 0.7F, 2.65F, 0.0F, 0.0F,
                                "biped/hit/execute", biped,
                                new AttackAnimation.Phase(0.0F, 0.75F, 0.51F, 0.95F, 3F, biped.toolR, null)
                                                .addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER,ValueModifier.multiplier(0.1F))
                                                .addProperty(AnimationProperty.AttackPhaseProperty.MAX_STRIKES_MODIFIER,ValueModifier.setter(1F))
                                                .addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.HOLD)
                                                .addProperty(AnimationProperty.AttackPhaseProperty.PARTICLE,EpicFightParticles.BLADE_RUSH_SKILL)
                                                .addProperty(AnimationProperty.AttackPhaseProperty.IMPACT_MODIFIER,ValueModifier.multiplier(5F))
                                                .addProperty(AnimationProperty.AttackPhaseProperty.HIT_SOUND, EpicFightSounds.EVISCERATE.get()),
                                new AttackAnimation.Phase(1.05F, 2.95F, 3.15F, 6.0F, Float.MAX_VALUE, biped.rootJoint,
                                                ColliderPreset.BIPED_BODY_COLLIDER)
                                                .addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE,StunType.KNOCKDOWN)
                                                .addProperty(AnimationProperty.AttackPhaseProperty.HIT_SOUND,EpicFightSounds.BLADE_RUSH_FINISHER.get())
                                                .addProperty(AnimationProperty.AttackPhaseProperty.PARTICLE,EpicFightParticles.EVISCERATE)
                                                .addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER,ValueModifier.multiplier(2F))
                                                .addProperty(AnimationProperty.AttackPhaseProperty.MAX_STRIKES_MODIFIER,ValueModifier.setter(1F))
                                                .addProperty(AnimationProperty.AttackPhaseProperty.EXTRA_DAMAGE,Set.of(ExtraDamageInstance.TARGET_LOST_HEALTH
                                                                                .create(0.2F))))
                                .addProperty(AnimationProperty.ActionAnimationProperty.STOP_MOVEMENT, true)
                                .addProperty(AnimationProperty.ActionAnimationProperty.MOVE_ON_LINK, false)
                                .addProperty(AnimationProperty.ActionAnimationProperty.COORD_SET_BEGIN,
                                                MoveCoordFunctions.TRACE_LOCROT_TARGET)
                                .addProperty(AnimationProperty.ActionAnimationProperty.COORD_SET_TICK,
                                                MoveCoordFunctions.TRACE_LOCROT_TARGET)
                                .addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER,
                                                Animations.ReusableSources.CONSTANT_ONE);
                EXECUTEED = new LongHitAnimation(0.05F, "biped/hit/guard_break1", biped);
                //// indestructible @s play
                //// "theforcelawtweaks:biped/combat/colossalsword/colossalsword_heavy1" 0 0
                COLOSSALSWORD_HEAVY_ATTACK1 = new AttackAnimation(0.1F, 1.167F, 1.167F, 1.367F, 2.167F,
                                InteractionHand.MAIN_HAND, null, biped.toolR,
                                "biped/combat/colossalsword/colossalsword_heavy1", biped)
                                .addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, 1.5F)
                                .addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER,
                                                ValueModifier.multiplier(1.75F))
                                .newTimePair(1.567F, Float.MAX_VALUE)
                                .addStateRemoveOld(EntityState.CAN_SKILL_EXECUTION, true)

                                .addEvents(AnimationEvent.TimePeriodEvent.create(0.01F, 0.54F,
                                                ((livingEntityPatch, staticAnimation, objects) -> {
                                                        // if(EpicFightKeyMappings.DODGE.isDown()){
                                                        // livingEntityPatch.playAnimationSynchronized(HANDHALFSWORD_DODGE_ATTACK1,
                                                        // 0.0F);ff
                                                        // }
                                                }), AnimationEvent.Side.CLIENT))
                                .addEvents(AnimationEvent.TimeStampedEvent
                                                .create(1.5F, Animations.ReusableSources.FRACTURE_GROUND_SIMPLE,
                                                                AnimationEvent.Side.CLIENT)
                                                .params(new Vec3f(3.0F, 0.0F, 1.3F),
                                                                yesman.epicfight.gameasset.Armatures.BIPED.rootJoint,
                                                                1.1D, 0.01F));
                COLOSSALSWORD_HEAVY_ATTACK2 = new AttackAnimation(0.1F, 1, 1, 1.4F, 2, InteractionHand.MAIN_HAND, null,
                                biped.toolR, "biped/combat/colossalsword/colossalsword_heavy2", biped)
                                .addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, 1.5F)
                                .addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER,
                                                ValueModifier.multiplier(1.75F))
                                .addEvents(AnimationEvent.TimePeriodEvent.create(0.01F, 0.61F,
                                                ((livingEntityPatch, staticAnimation, objects) -> {
                                                        // if(EpicFightKeyMappings.DODGE.isDown()){
                                                        // livingEntityPatch.playAnimationSynchronized(HANDHALFSWORD_DODGE_ATTACK2,
                                                        // 0.0F);
                                                        // }
                                                }), AnimationEvent.Side.CLIENT))
                                .addEvents(AnimationEvent.TimeStampedEvent
                                                .create(1.43F, Animations.ReusableSources.FRACTURE_GROUND_SIMPLE,
                                                                AnimationEvent.Side.CLIENT)
                                                .params(new Vec3f(3.0F, 0.0F, 1.3F),
                                                                yesman.epicfight.gameasset.Armatures.BIPED.rootJoint,
                                                                1.1D, 0.01F));

                // --------------------------------------------------------
                TACHI_IDLE = new StaticAnimation(true, "biped/combat/dual_tachi/uchigatana_idle", biped);
                TACHI_WALK = new MovementAnimation(true, "biped/combat/dual_tachi/uchigatana_walk", biped);
                TACHI_RUN = new MovementAnimation(true, "biped/combat/dual_tachi/uchigatana_run", biped);

                UCHIGATANA_AUTO1 = new BasicAttackAnimation(0.05F, 0.467F, 0.6F, 0.833F, null, biped.toolR,
                                "biped/combat/dual_tachi/uchigatana_auto1", biped)
                                .addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, 0.9F)
                                .addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.HOLD)
                                .addProperty(AnimationProperty.AttackPhaseProperty.IMPACT_MODIFIER,
                                                ValueModifier.setter(1.5F));
                UCHIGATANA_AUTO2 = new BasicAttackAnimation(0.05F, 0.433F, 0.55F, 0.833F, null, biped.toolR,
                                "biped/combat/dual_tachi/uchigatana_auto2", biped)
                                .addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, 0.9F);
                UCHIGATANA_AUTO3 = new BasicAttackAnimation(0.05F, 0.4F, 0.7F, 0.833F, null, biped.toolR,
                                "biped/combat/dual_tachi/uchigatana_auto3", biped)
                                .addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, 0.9F)
                                .addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.HOLD)
                                .addProperty(AnimationProperty.AttackPhaseProperty.IMPACT_MODIFIER,
                                                ValueModifier.setter(1.25F));
                UCHIGATANA_AUTO4 = new BasicAttackAnimation(0.05F, 0.467F, 0.7F, 0.833F, null, biped.toolR,
                                "biped/combat/dual_tachi/uchigatana_auto4", biped)
                                .addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, 0.9F)
                                .addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.HOLD)
                                .addProperty(AnimationProperty.AttackPhaseProperty.IMPACT_MODIFIER,
                                                ValueModifier.setter(1.5F));
                UCHIGATANA_AUTO5 = new BasicAttackAnimation(0.05F, 0.567F, 0.667F, 1F, null, biped.toolR,
                                "biped/combat/dual_tachi/uchigatana_auto5", biped)
                                .addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, 1.0F)
                                .addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.LONG);
                UCHIGATANA_DASH = new DashAttackAnimation(0.1F, 0.5F, 0.6F, 0.7F, 1.2F, null, biped.toolR,
                                "biped/combat/dual_tachi/uchigatana_dash", biped)
                                .addProperty(AnimationProperty.ActionAnimationProperty.STOP_MOVEMENT, true)
                                .addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER,
                                                Animations.ReusableSources.CONSTANT_ONE);
                DUAL_TACHI_AUTO1 = new BasicAttackAnimation(0.05F, "biped/combat/dual_tachi/dual_tachi_auto1", biped,
                                new AttackAnimation.Phase(0.0F, 0.367F, 0.41F, 1.2F, 1.3F, InteractionHand.OFF_HAND,
                                                biped.toolL, null),
                                new AttackAnimation.Phase(0.2F, 0.633F, 0.68F, 1F, 1.3F, biped.toolR, null))
                                .addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.HOLD)
                                .addProperty(AnimationProperty.AttackPhaseProperty.IMPACT_MODIFIER,
                                                ValueModifier.setter(1.5F))
                                .addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, 1.2F);
                DUAL_TACHI_AUTO2 = new BasicAttackAnimation(0.05F, "biped/combat/dual_tachi/dual_tachi_auto2", biped,
                                new AttackAnimation.Phase(0.0F, 0.5F, 0.63F, 0.667F, 0.667F, InteractionHand.MAIN_HAND,
                                                biped.toolR, null),
                                new AttackAnimation.Phase(0.2F, 0.7F, 0.8F, 1.167F, 0.8F, biped.toolL, null))
                                .addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, 1.0F)
                                .addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.HOLD)
                                .addProperty(AnimationProperty.AttackPhaseProperty.IMPACT_MODIFIER,
                                                ValueModifier.setter(2.5F));
                DUAL_TACHI_AUTO3 = new BasicAttackAnimation(0.05F, "biped/combat/dual_tachi/dual_tachi_auto3", biped,
                                new AttackAnimation.Phase(0.0F, 0.66F, 0.69F, 0.733F, 1F, Float.MAX_VALUE, false,
                                                InteractionHand.MAIN_HAND,
                                                List.of(Pair.of(biped.toolR, null), Pair.of(biped.toolL, null))))
                                .addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, 1.0F)
                                .addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.HOLD)
                                .addProperty(AnimationProperty.AttackPhaseProperty.IMPACT_MODIFIER,
                                                ValueModifier.setter(2.5F));
                DUAL_TACHI_AUTO4 = new BasicAttackAnimation(0.05F, "biped/combat/dual_tachi/dual_tachi_auto4", biped,
                                new AttackAnimation.Phase(0.0F, 0.633F, 0.69F, 0.8F, 1.167F, 1.169F, false,
                                                InteractionHand.MAIN_HAND,
                                                List.of(Pair.of(biped.toolR, null), Pair.of(biped.toolL, null))))
                                .addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, 1.2F)
                                .addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.LONG);

                DUAL_TACHI_AUTO5 = new BasicAttackAnimation(0.05F, "biped/combat/dual_tachi/dual_tachi_auto5", biped,
                        new AttackAnimation.Phase(0.0F, 0.367F, 0.41F, 0.567F, 1.3F, InteractionHand.OFF_HAND,
                                biped.toolL, null),
                        new AttackAnimation.Phase(0.2F, 0.633F, 0.68F, 0.767F, 1.3F, biped.toolR, null))
                        .addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.HOLD)
                        .addProperty(AnimationProperty.AttackPhaseProperty.IMPACT_MODIFIER,
                                ValueModifier.setter(1.5F))
                        .addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, 1.2F);

                DUAL_TACHI_SKILL1 = new BasicAttackAnimation(0.5F, 0.967F, 1.1F, 1.3333F, null, biped.toolR,
                                "biped/combat/dual_tachi/uchigatana_heavy1", biped)
                                .addProperty(AnimationProperty.AttackAnimationProperty.ATTACK_SPEED_FACTOR, 0.9F)
                                .addProperty(AnimationProperty.AttackPhaseProperty.ARMOR_NEGATION_MODIFIER,
                                                ValueModifier.setter(25F))
                                .addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER,
                                                Animations.ReusableSources.CONSTANT_ONE)
                                .addState(EntityState.MOVEMENT_LOCKED, true);
                DUAL_TACHI_SKILL2 = new BasicAttackAnimation(0.5F, 1.167F, 1.35F, 1.667F, null, biped.toolR,
                                "biped/combat/dual_tachi/uchigatana_heavy2", biped)
                                .addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.FALL)
                                .addProperty(AnimationProperty.AttackPhaseProperty.IMPACT_MODIFIER,ValueModifier.setter(3F))
                                .addProperty(AnimationProperty.AttackPhaseProperty.ARMOR_NEGATION_MODIFIER, ValueModifier.setter(25F))
                                .addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER,Animations.ReusableSources.CONSTANT_ONE)
                                .addState(EntityState.MOVEMENT_LOCKED, true);

                // indestructible @s play
                // "theforcelawtweaks:biped/combat/dual_tachi/uchigatana_heavy1" 0 0

        }

}
