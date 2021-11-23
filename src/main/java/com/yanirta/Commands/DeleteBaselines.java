package com.yanirta.Commands;

import com.beust.jcommander.converters.CommaParameterSplitter;
import com.yanirta.obj.Contexts.BranchesAPIContext;
import com.yanirta.utils.BaselinesManager;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;

import java.util.ArrayList;
import java.util.List;

@Parameters(commandDescription = "Performs baselines delete operation")
public class DeleteBaselines extends BaselineCommand {
    @Parameter(
            names = {"-bld", "-baselinesToDelete"},
            description = "Delete all baselines with the provided ids.",
            variableArity = true
    )
    private List<String> baselinesToDelete = new ArrayList<>();

    @Override
    public void run() throws Exception {
        BranchesAPIContext context = BranchesAPIContext.Init(getFormattedServerUrl(), apiKey);
        BaselinesManager baselinesManager = new BaselinesManager(context);
        if (baselinesManager.deleteBaselines(baselinesToDelete)) {
            System.out.println("Request to delete baselines succeeded");
        } else {
            System.out.println("Failed to make delete baselines request");
        }
    }
}
