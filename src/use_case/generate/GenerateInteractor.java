package use_case.generate;

import entity.Playlist;

import java.io.IOException;
import java.util.List;

public class GenerateInteractor implements GenerateInputBoundary{
    final GenerateOutputBoundary userPresenter;
    final CreatePlaylistHelper createPlaylistHelper;

    public GenerateInteractor(GenerateOutputBoundary generateOutputBoundary,
                              CreatePlaylistHelper createPlaylistHelper) {
        this.userPresenter = generateOutputBoundary;
        this.createPlaylistHelper = createPlaylistHelper;
    }

    @Override
    public void execute(GenerateInputData generateInputData) throws IOException {
        Playlist output = createPlaylistHelper.generatePlaylists(generateInputData.getGenre(),
                generateInputData.getPopularity(),
                generateInputData.getDanceability(),
                generateInputData.getValence(),
                generateInputData.getSpeechiness(),
                generateInputData.getEnergy(),
                generateInputData.getNumberOfTracks());

        GenerateOutputData generateOutputData = new GenerateOutputData(output);
        userPresenter.prepareSuccessView(generateOutputData);
    }
}
