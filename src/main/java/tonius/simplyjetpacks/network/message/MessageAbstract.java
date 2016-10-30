package tonius.simplyjetpacks.network.message;

import tonius.simplyjetpacks.SimplyJetpacks;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public abstract class MessageAbstract<T extends MessageAbstract<T>> implements IMessage, IMessageHandler<T, IMessage> {

	@Override
	public IMessage onMessage(T message, MessageContext messageContext) {
		SimplyJetpacks.proxy.handleMessage(message, messageContext);

		return null;
	}

	/**
	 * Executes when the message is received on CLIENT side. Never use fields directly from the class you're in, but
	 * use data from the 'message' argument instead.
	 *
	 * @param client         the minecraft client instance.
	 * @param message        The message instance with all variables.
	 * @param player         The client player entity.
	 * @param messageContext the message context.
	 */
	@SideOnly(Side.CLIENT)
	public abstract void onClientReceived(Minecraft client, T message, EntityPlayer player, MessageContext messageContext);

	/**
	 * Executes when the message is received on SERVER side. Never use fields directly from the class you're in, but
	 * use data from the 'message' argument instead.
	 *
	 * @param server         the minecraft server instance.
	 * @param message        The message instance with all variables.
	 * @param player         The player who sent the message to the server.
	 * @param messageContext the message context.
	 */
	public abstract void onServerReceived(MinecraftServer server, T message, EntityPlayer player, MessageContext messageContext);
}
