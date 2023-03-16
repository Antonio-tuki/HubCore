package dev.fxmxgragfx.hub.tablist;

import net.minecraft.server.v1_7_R4.EnumProtocol;

import java.util.Collection;
import java.util.Map;
import java.util.UUID;

public class ReflectionConstants
{
    public static Class<?> TAB_PACKET_CLASS;
    public static Reflection.ConstructorInvoker TAB_PACKET_CONSTRUCTOR;
    public static Reflection.FieldAccessor TAB_PACKET_ACTION;
    public static Reflection.FieldAccessor TAB_PACKET_NAME;
    public static Class<?> GAME_PROFILE_CLASS;
    public static Reflection.ConstructorInvoker GAME_PROFILE_CONSTRUCTOR;
    public static Reflection.FieldAccessor GAME_PROFILE_NAME;
    public static Reflection.FieldAccessor TAB_PACKET_PROFILE;
    public static Class<?> CRAFT_PLAYER_CLASS;
    public static Class<?> NMS_PACKET_CLASS;
    public static Class<?> NMS_PLAYER_CLASS;
    public static Class<?> PLAYER_CONNECTION_CLASS;
    public static Class<?> NETWORK_MANAGER_CLASS;
    public static Reflection.MethodInvoker GET_HANDLE_METHOD;
    public static Reflection.MethodInvoker GET_PROFILE_METHOD;
    public static Reflection.MethodInvoker VERSION_METHOD;
    public static Reflection.MethodInvoker SEND_PACKET;
    public static Reflection.FieldAccessor PLAYER_CONNECTION;
    public static Reflection.FieldAccessor NETWORK_MANAGER;
    public static Class<?> SCOREBOARD_TEAM_CLASS;
    public static Reflection.ConstructorInvoker SCOREBOARD_TEAM_CONSTRUCTOR;
    public static Reflection.FieldAccessor SCOREBOARD_TEAM_NAME;
    public static Reflection.FieldAccessor SCOREBOARD_TEAM_DISPLAY_NAME;
    public static Reflection.FieldAccessor SCOREBOARD_TEAM_PREFIX;
    public static Reflection.FieldAccessor SCOREBOARD_TEAM_SUFFIX;
    public static Reflection.FieldAccessor SCOREBOARD_TEAM_PLAYERS;
    public static Reflection.FieldAccessor SCOREBOARD_TEAM_ACTION;
    public static Reflection.FieldAccessor SCOREBOARD_TEAM_OPTIONS;
    public static Class<?> ENUM_PROTOCOL_CLASS;
    public static Reflection.FieldAccessor ENUM_PROTOCOL_PLAY;
    public static Reflection.FieldAccessor ENUM_PROTOCOL_REGISTRY;

    static {
        ReflectionConstants.TAB_PACKET_CLASS = Reflection.getMinecraftClass("PacketPlayOutPlayerInfo");
        ReflectionConstants.TAB_PACKET_CONSTRUCTOR = Reflection.getConstructor(ReflectionConstants.TAB_PACKET_CLASS, (Class<?>[])new Class[0]);
        ReflectionConstants.TAB_PACKET_ACTION = Reflection.getField(ReflectionConstants.TAB_PACKET_CLASS, Integer.TYPE, 5);
        ReflectionConstants.TAB_PACKET_NAME = Reflection.getField(ReflectionConstants.TAB_PACKET_CLASS, String.class, 0);
        ReflectionConstants.GAME_PROFILE_CLASS = getUntypedClasses("net.minecraft.util.com.mojang.authlib.GameProfile", "com.mojang.authlib.GameProfile");
        ReflectionConstants.GAME_PROFILE_CONSTRUCTOR = Reflection.getConstructor(ReflectionConstants.GAME_PROFILE_CLASS, UUID.class, String.class);
        ReflectionConstants.GAME_PROFILE_NAME = Reflection.getField(ReflectionConstants.GAME_PROFILE_CLASS, String.class, 0);
        ReflectionConstants.TAB_PACKET_PROFILE = Reflection.getField(ReflectionConstants.TAB_PACKET_CLASS, ReflectionConstants.GAME_PROFILE_CLASS, 0);
        ReflectionConstants.CRAFT_PLAYER_CLASS = Reflection.getCraftBukkitClass("entity.CraftPlayer");
        ReflectionConstants.NMS_PACKET_CLASS = Reflection.getMinecraftClass("Packet");
        ReflectionConstants.NMS_PLAYER_CLASS = Reflection.getMinecraftClass("EntityPlayer");
        ReflectionConstants.PLAYER_CONNECTION_CLASS = Reflection.getMinecraftClass("PlayerConnection");
        ReflectionConstants.NETWORK_MANAGER_CLASS = Reflection.getMinecraftClass("NetworkManager");
        ReflectionConstants.GET_HANDLE_METHOD = Reflection.getMethod(ReflectionConstants.CRAFT_PLAYER_CLASS, "getHandle", (Class<?>[])new Class[0]);
        ReflectionConstants.GET_PROFILE_METHOD = Reflection.getMethod(ReflectionConstants.CRAFT_PLAYER_CLASS, "getProfile", (Class<?>[])new Class[0]);
        ReflectionConstants.VERSION_METHOD = Reflection.getMethod(ReflectionConstants.NETWORK_MANAGER_CLASS, "getVersion", (Class<?>[])new Class[0]);
        ReflectionConstants.SEND_PACKET = Reflection.getMethod(ReflectionConstants.PLAYER_CONNECTION_CLASS, "sendPacket", ReflectionConstants.NMS_PACKET_CLASS);
        ReflectionConstants.PLAYER_CONNECTION = Reflection.getField(ReflectionConstants.NMS_PLAYER_CLASS, ReflectionConstants.PLAYER_CONNECTION_CLASS, 0);
        ReflectionConstants.NETWORK_MANAGER = Reflection.getField(ReflectionConstants.PLAYER_CONNECTION_CLASS, ReflectionConstants.NETWORK_MANAGER_CLASS, 0);
        ReflectionConstants.SCOREBOARD_TEAM_CLASS = Reflection.getMinecraftClass("PacketPlayOutScoreboardTeam");
        ReflectionConstants.SCOREBOARD_TEAM_CONSTRUCTOR = Reflection.getConstructor(ReflectionConstants.SCOREBOARD_TEAM_CLASS, (Class<?>[])new Class[0]);
        ReflectionConstants.SCOREBOARD_TEAM_NAME = Reflection.getField(ReflectionConstants.SCOREBOARD_TEAM_CLASS, String.class, 0);
        ReflectionConstants.SCOREBOARD_TEAM_DISPLAY_NAME = Reflection.getField(ReflectionConstants.SCOREBOARD_TEAM_CLASS, String.class, 1);
        ReflectionConstants.SCOREBOARD_TEAM_PREFIX = Reflection.getField(ReflectionConstants.SCOREBOARD_TEAM_CLASS, String.class, 2);
        ReflectionConstants.SCOREBOARD_TEAM_SUFFIX = Reflection.getField(ReflectionConstants.SCOREBOARD_TEAM_CLASS, String.class, 3);
        ReflectionConstants.SCOREBOARD_TEAM_PLAYERS = Reflection.getField(ReflectionConstants.SCOREBOARD_TEAM_CLASS, Collection.class, 0);
        ReflectionConstants.SCOREBOARD_TEAM_ACTION = Reflection.getField(ReflectionConstants.SCOREBOARD_TEAM_CLASS, Integer.TYPE, 0);
        ReflectionConstants.SCOREBOARD_TEAM_OPTIONS = Reflection.getField(ReflectionConstants.SCOREBOARD_TEAM_CLASS, Integer.TYPE, 1);
        ReflectionConstants.ENUM_PROTOCOL_CLASS = Reflection.getMinecraftClass("EnumProtocol");
        ReflectionConstants.ENUM_PROTOCOL_PLAY = Reflection.getField(ReflectionConstants.ENUM_PROTOCOL_CLASS, ReflectionConstants.ENUM_PROTOCOL_CLASS, 1);
        ReflectionConstants.ENUM_PROTOCOL_REGISTRY = Reflection.getField(ReflectionConstants.ENUM_PROTOCOL_CLASS, Map.class, 0);
    }

    public static Class<?> getUntypedClasses(final String... lookupNames) {
        EnumProtocol.class.getName();
        final int length = lookupNames.length;
        int i = 0;
        while (i < length) {
            final String lookupName = lookupNames[i];
            try {
                return Reflection.getUntypedClass(lookupName);
            }
            catch (IllegalArgumentException var5) {
                ++i;
            }
        }
        throw new IllegalArgumentException("No class found in selection given");
    }
}

