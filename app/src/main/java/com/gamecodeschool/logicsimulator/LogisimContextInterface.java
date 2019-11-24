//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// This class stores the context intend to be used in the Logisim program.
// This context is used by many class like AbstractGridCellSaves for the saving and loading
// of cells and vectors of cells
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

package com.gamecodeschool.logicsimulator;

import android.content.Context;

public class LogisimContextInterface {
    Context context;

    LogisimContextInterface(Context context){ setContext(context);}

    public void setContext(Context context){this.context = context;}

    public Context getContext() {
        return context;
    }

}
