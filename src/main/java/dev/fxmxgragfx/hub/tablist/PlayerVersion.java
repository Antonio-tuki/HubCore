package dev.fxmxgragfx.hub.tablist;

import org.bukkit.entity.Player;

public enum PlayerVersion
{
    v1_7("v1_7", 0, "v1_7", 0),
    v1_8("v1_8", 1, "v1_8", 1);

    private PlayerVersion(final String s2, final int n2, final String s, final int n) {
    }

    public static PlayerVersion getVersion(final Player player) {
        final Object handle = ReflectionConstants.GET_HANDLE_METHOD.invoke(player, new Object[0]);
        final Object connection = ReflectionConstants.PLAYER_CONNECTION.get(handle);
        final Object manager = ReflectionConstants.NETWORK_MANAGER.get(connection);
        final Object version = ReflectionConstants.VERSION_METHOD.invoke(manager, new Object[0]);
        if (version instanceof Integer) {
            return ((int)version > 5) ? PlayerVersion.v1_8 : PlayerVersion.v1_7;
        }
        return PlayerVersion.v1_7;
    }
}
