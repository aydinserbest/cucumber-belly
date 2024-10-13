package io.belly.skeleton.step_definitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;

public class BoardStepDefinitions {
    private List<List<String>> board;
    @Given("a board like this:")
    public void a_board_like_this(DataTable dataTable) {
        this.board = dataTable.asLists();
    }
    @When("player x plays in row {int}, column {int}")
    public void player_x_plays_in_row_column(int row, int col) {
        board.get(row).set(col, "X");
    }
    @Then("the board should look like this:")
    public void the_board_should_look_like_this(DataTable expectedTable) {
        expectedTable.diff(DataTable.create(board));

    }
}
