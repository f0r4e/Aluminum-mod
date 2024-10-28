package com.aluminum;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.gamerule.v1.GameRuleFactory;
import net.fabricmc.fabric.api.gamerule.v1.GameRuleRegistry;

import net.minecraft.world.GameRules;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Al implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
    public static final Logger LOGGER = LoggerFactory.getLogger("al");
	public static final GameRules.Key<GameRules.IntRule> PISTON_PUSHING_LIMIT =  GameRuleRegistry.register("PistonPushingLimit", GameRules.Category.MISC, GameRuleFactory.createIntRule(12,0));

	public static final GameRules.Key<GameRules.BooleanRule> PISTON_FORCE_PUSH = GameRuleRegistry.register("PistonForcePush",GameRules.Category.MISC, GameRuleFactory.createBooleanRule(false));
	@Override
	public void onInitialize() {
		LOGGER.info("aluminum has been loaded!");

	}}
