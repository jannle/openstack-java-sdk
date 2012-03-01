package org.openstack.client.cli.commands;

import org.openstack.client.cli.OpenstackCache;
import org.openstack.client.cli.OpenstackCliContext;
import org.openstack.client.common.OpenstackComputeClient;
import org.openstack.client.common.OpenstackSession;
import org.openstack.client.storage.OpenstackStorageClient;

import com.fathomdb.cli.commands.CommandRunnerBase;
import com.fathomdb.cli.commands.CommandSpecifier;

public abstract class OpenstackCliCommandRunnerBase extends CommandRunnerBase {

	protected OpenstackCliCommandRunnerBase(String verb, String noun) {
		super(verb, noun);
	}

	protected OpenstackCliCommandRunnerBase(CommandSpecifier commandSpecifier) {
		super(commandSpecifier);
	}

	protected OpenstackComputeClient getComputeClient() {
		return getContext().getComputeClient();
	}

	protected OpenstackStorageClient getStorageClient() {
		return getOpenstackSession().getStorageClient();
	}

	protected OpenstackSession getOpenstackSession() {
		return getContext().getOpenstackSession();
	}

	protected OpenstackCliContext getContext() {
		return (OpenstackCliContext) super.getContext();
	}

	protected void invalidateCache(Class<?> modelClass) {
		getCache().invalidateCache(modelClass);
	}

	protected OpenstackCache getCache() {
		return getContext().getCache();
	}
}
