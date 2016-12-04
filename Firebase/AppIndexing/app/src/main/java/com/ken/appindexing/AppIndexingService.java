package com.ken.appindexing;

import android.app.IntentService;
import android.content.Intent;

import com.google.firebase.appindexing.FirebaseAppIndex;
import com.google.firebase.appindexing.Indexable;
import com.google.firebase.appindexing.builders.Indexables;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mryit on 12/4/2016.
 */

public class AppIndexingService extends IntentService {

    public AppIndexingService() {
        super("AppIndexingService");
    }

    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     * @param name Used to name the worker thread, important only for debugging.
     */
    public AppIndexingService(String name) {
        super(name);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        ArrayList<Indexable> indexableNotes = new ArrayList<>();

        for (Recipe recipe : getAllRecipes()) {
            Recipe.Note note = recipe.getNote();
            if (note != null) {
                Indexable noteToIndex = Indexables.noteDigitalDocumentBuilder()
                        .setName(recipe.getTitle() + " Note")
                        .setText(note.getText())
                        .setUrl(recipe.getNoteUrl())
                        .build();

                indexableNotes.add(noteToIndex);
            }
        }

        if (indexableNotes.size() > 0) {
            Indexable[] notesArr = new Indexable[indexableNotes.size()];
            notesArr = indexableNotes.toArray(notesArr);

            // batch insert indexable notes into index
            FirebaseAppIndex.getInstance().update(notesArr);
        }
    }

    // [START_EXCLUDE]
    private List<Recipe> getAllRecipes() {
        ArrayList recipesList = new ArrayList();
        // Code access all recipes with their notes from the database here.
        return recipesList;
    }
    // [END_EXCLUDE]

}
