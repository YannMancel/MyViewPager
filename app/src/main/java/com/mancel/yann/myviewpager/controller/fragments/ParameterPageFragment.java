package com.mancel.yann.myviewpager.controller.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.mancel.yann.myviewpager.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ParameterPageFragment extends Fragment {

    // FIELDS --------------------------------------------------------------------------------------

    private LinearLayout mLinearLayout;
    private TextView mTextView;

    private int mColor;

    private static String BUNDLE_COLOR = "com.mancel.yann.myviewpager.controller.fragments.ParameterPageFragment.BUNDLE_COLOR";

    // CONSTRUCTORS --------------------------------------------------------------------------------

    public ParameterPageFragment() {}

    // METHODS -------------------------------------------------------------------------------------

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this View object
        View view = inflater.inflate(R.layout.fragment_parameter_page, container, false);

        // Configures the LinearLayout field
        this.configureLinearLayout(view);

        // Configures the TextView field
        this.configureTextView(view);

        // Retrieves the arguments of the fragment vie the Bundle object
        this.retrieveArguments();

        // Updates the UI
        this.updateUI();

        return view;
    }

    /**
     * Creates a new instance of the ParameterPageFragment class
     *
     * @param color an integer that contains the color value for the LinearLayout field
     *
     * @return a ParameterPageFragment object
     */
    public static ParameterPageFragment newInstance(final int color) {
        // Creates a PageFragment object
        ParameterPageFragment parameterPageFragment = new ParameterPageFragment();

        // Creates a Bundle object to add the fragment color
        Bundle bundle = new Bundle();

        // Adds the fragment color
        bundle.putInt(BUNDLE_COLOR, color);

        // Sets the arguments via the Bundle object
        parameterPageFragment.setArguments(bundle);

        return parameterPageFragment;
    }

    /**
     * Configures the LinearLayout field
     *
     * @param view a View object that contains the parent view
     */
    private void configureLinearLayout(final View view) {
        // Initializes the LinearLayout field
        this.mLinearLayout = (LinearLayout) view.findViewById(R.id.fragment_parameter_page_LinearLayout);
    }

    /**
     * Configures the TextView field
     *
     * @param view a View object that contains the parent view
     */
    private void configureTextView(final View view) {
        // Initializes the TextView field
        this.mTextView = (TextView) view.findViewById(R.id.fragment_parameter_page_TextView);
    }

    /**
     * Retrieves the arguments of the fragment vie the Bundle object
     */
    private void retrieveArguments() {
        // Retrieves the color from Bundle object
        this.mColor = getArguments().getInt(BUNDLE_COLOR, 0);
    }

    /**
     * Updates the UI
     */
    private void updateUI() {
        // Updates the background color of the LinearLayout field
        this.mLinearLayout.setBackgroundColor(this.mColor);

        // Updates the text of the TextView field
        this.mTextView.setText(getResources().getString(R.string.parameter));
    }
}

