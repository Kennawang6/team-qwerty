package com.example.qwertracker.ui.graph;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.qwertracker.MainActivity;
import com.example.qwertracker.R;
import com.example.qwertracker.data.AppDatabase;
import com.example.qwertracker.data.HappinessResponse;
import com.example.qwertracker.data.SurveyResponseDao;
import com.example.qwertracker.ui.dashboard.DashboardViewModel;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;
import java.util.List;




public class GraphFragment extends Fragment {
    EditText firstNum_1, secondNum_1;
    EditText firstNum_2, secondNum_2;
    EditText firstNum_3, secondNum_3;
    EditText firstNum_4, secondNum_4;

    SurveyResponseDao accessor;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        MainActivity activity = ((MainActivity) getActivity());
        if (activity == null) {
            // BIG TROUBLE, shouldn't happen
            System.err.println("Graph Fragment could not find activity. This is a problem!");
        } else {
            accessor = activity.getAccessor();
        }
        // TODO the following code might (I didn't try it) be able to query survey responses entered in the past 100000000 seconds
        // It doesn't like accessing database in main, cf. https://stackoverflow.com/questions/44167111/android-room-simple-select-query-cannot-access-database-on-the-main-thread
        /*long currentTime = System.currentTimeMillis();
        try {
            List<HappinessResponse> response = accessor.getHappinessResponsesBetween(currentTime - 1000000000, currentTime);
            // String element1 = response.get(1).toString();
            System.out.println(response);
        } catch (Exception e) {
            e.printStackTrace();
        }*/

    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_graph, container, false);
        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        /*firstNum_1 = view.findViewById(R.id.firstNum_1);
        secondNum_1 = view.findViewById(R.id.secondNum_1);
        firstNum_2 = view.findViewById(R.id.firstNum_2);
        secondNum_2 = view.findViewById(R.id.secondNum_2);
        firstNum_3 = view.findViewById(R.id.firstNum_3);
        secondNum_3 = view.findViewById(R.id.secondNum_3);
        firstNum_4 = view.findViewById(R.id.firstNum_4);
        secondNum_4 = view.findViewById(R.id.secondNum_4);*/
        final GraphView graph = (GraphView) view.findViewById(R.id.graph);

        graph.setVisibility(View.VISIBLE);
        graph.getViewport().setXAxisBoundsManual(true);
        graph.getViewport().setMinX(1);
        graph.getViewport().setMaxX(5);
        graph.getViewport().setYAxisBoundsManual(true);
        graph.getViewport().setMinY(1);
        graph.getViewport().setMaxY(5);

        com.jjoe64.graphview.helper.StaticLabelsFormatter staticLabelsFormatter = new com.jjoe64.graphview.helper.StaticLabelsFormatter(graph);
        staticLabelsFormatter.setHorizontalLabels(new String[]{"Mon", "Tue", "Wed", "Thu", "Fri"});
        //staticLabelsFormatter.setHorizontalLabels(new String[]{"Mon"," ", "Tue"," ", "Wed"," ", "Thu"," ", "Fri"});
        graph.getGridLabelRenderer().setLabelFormatter(staticLabelsFormatter);

        Button button = view.findViewById(R.id.addButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*String firstInput_1, secondInput_1;
                String firstInput_2, secondInput_2;
                String firstInput_3, secondInput_3;
                String firstInput_4, secondInput_4;
                //  1 and 5
                firstInput_1 = firstNum_1.getText().toString();
                secondInput_1 = secondNum_1.getText().toString();
                firstInput_2 = firstNum_2.getText().toString();
                secondInput_2 = secondNum_2.getText().toString();
                firstInput_3 = firstNum_3.getText().toString();
                secondInput_3 = secondNum_3.getText().toString();
                firstInput_4 = firstNum_4.getText().toString();
                secondInput_4 = secondNum_4.getText().toString();*/
                try {
                    LineGraphSeries<DataPoint> series = new LineGraphSeries<>(new DataPoint[]{
                            new DataPoint(0, 1),
                            new DataPoint(1, 5),
                            new DataPoint(2,4),
                            new DataPoint(3,5),
                            new DataPoint(4,2),
                            new DataPoint(5, 4)
                            //new DataPoint(Integer.valueOf(firstInput_1), Integer.valueOf(secondInput_1)),
                            //new DataPoint(Integer.valueOf(firstInput_2), Integer.valueOf(secondInput_2)),
                            //new DataPoint(Integer.valueOf(firstInput_3), Integer.valueOf(secondInput_3)),
                            //new DataPoint(Integer.valueOf(firstInput_4), Integer.valueOf(secondInput_4))
                    });
                    graph.removeAllSeries();
                    series.setColor(android.graphics.Color.rgb(104, 209, 197));
                    graph.addSeries(series);
                } catch (IllegalArgumentException e) {
                    // TODO error handling?
                }
            }
        });

        Button button2 = view.findViewById(R.id.addButton2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    LineGraphSeries<DataPoint> series = new LineGraphSeries<>(new DataPoint[]{
                            new DataPoint(0, 1),
                            new DataPoint(1, 3),
                            new DataPoint(2,5),
                            new DataPoint(3,2),
                            new DataPoint(4,1),
                            new DataPoint(5, 3)
                    });
                    graph.removeAllSeries();
                    series.setColor(android.graphics.Color.rgb(250, 239, 215));
                    graph.addSeries(series);
                } catch (IllegalArgumentException e) {
                    // TODO error handling?
                }
            }
        });

        Button button3 = view.findViewById(R.id.addButton3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    LineGraphSeries<DataPoint> series = new LineGraphSeries<>(new DataPoint[]{
                            new DataPoint(0, 4),
                            new DataPoint(1, 2),
                            new DataPoint(2,2),
                            new DataPoint(3,5),
                            new DataPoint(4,3),
                            new DataPoint(5, 4)
                    });
                    graph.removeAllSeries();
                    series.setColor(android.graphics.Color.rgb(117, 199, 234));
                    graph.addSeries(series);
                } catch (IllegalArgumentException e) {
                    // TODO error handling?
                }
            }
        });

        Button button4 = view.findViewById(R.id.addButton4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    LineGraphSeries<DataPoint> series = new LineGraphSeries<>(new DataPoint[]{
                            new DataPoint(0, 3),
                            new DataPoint(1, 3),
                            new DataPoint(2,1),
                            new DataPoint(3,2),
                            new DataPoint(4,1),
                            new DataPoint(5, 5)
                    });
                    graph.removeAllSeries();
                    series.setColor(android.graphics.Color.rgb(242, 183, 184));
                    graph.addSeries(series);
                } catch (IllegalArgumentException e) {
                    // TODO error handling?
                }
            }
        });

        Button button5 = view.findViewById(R.id.addButton5);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    // For the record, i am not proud of this
                    LineGraphSeries<DataPoint> series = new LineGraphSeries<>(new DataPoint[]{
                            new DataPoint(0, 1),
                            new DataPoint(1, 5),
                            new DataPoint(2, 4),
                            new DataPoint(3, 5),
                            new DataPoint(4, 2),
                            new DataPoint(5, 4)
                    });
                    series.setColor(android.graphics.Color.rgb(104, 209, 197));
                    graph.addSeries(series);
                    LineGraphSeries<DataPoint> series2 = new LineGraphSeries<>(new DataPoint[]{
                            new DataPoint(0, 1),
                            new DataPoint(1, 3),
                            new DataPoint(2,5),
                            new DataPoint(3,2),
                            new DataPoint(4,1),
                            new DataPoint(5, 3)
                    });
                    series2.setColor(android.graphics.Color.rgb(250, 239, 215));
                    graph.addSeries(series2);
                    LineGraphSeries<DataPoint> series3 = new LineGraphSeries<>(new DataPoint[]{
                            new DataPoint(0, 4),
                            new DataPoint(1, 2),
                            new DataPoint(2,2),
                            new DataPoint(3,5),
                            new DataPoint(4,3),
                            new DataPoint(5, 4)
                    });
                    series3.setColor(android.graphics.Color.rgb(117, 199, 234));
                    graph.addSeries(series3);
                    LineGraphSeries<DataPoint> series4 = new LineGraphSeries<>(new DataPoint[]{
                            new DataPoint(0, 3),
                            new DataPoint(1, 3),
                            new DataPoint(2,1),
                            new DataPoint(3,2),
                            new DataPoint(4,1),
                            new DataPoint(5, 5)
                    });
                    series4.setColor(android.graphics.Color.rgb(242, 183, 184));
                    graph.addSeries(series4);




                } catch (IllegalArgumentException e) {
                    // TODO error handling?
                }
            }
        });
    }
    /*@Override
    public void initGraph(GraphView graph) {
        // generate Dates
        Calendar calendar = Calendar.getInstance();
        Date d1 = calendar.getTime();
        calendar.add(Calendar.DATE, 1);
        Date d2 = calendar.getTime();
        calendar.add(Calendar.DATE, 1);
        Date d3 = calendar.getTime();

        // you can directly pass Date objects to DataPoint-Constructor
        // this will convert the Date to double via Date#getTime()
        LineGraphSeries<DataPoint> series = new LineGraphSeries<DataPoint>(new DataPoint[] {
                new DataPoint(d1, 1),
                new DataPoint(d2, 5),
                new DataPoint(d3, 3)
        });
        graph.addSeries(series);

        // set date label formatter
        graph.getGridLabelRenderer().setLabelFormatter(new DateAsXAxisLabelFormatter(graph.getContext()));
        graph.getGridLabelRenderer().setNumHorizontalLabels(mNumLabels);

        // set manual x bounds to have nice steps
        graph.getViewport().setMinX(d1.getTime());
        graph.getViewport().setMaxX(d3.getTime());
        graph.getViewport().setXAxisBoundsManual(true);

        // as we use dates as labels, the human rounding to nice readable numbers
        // is not nessecary
        graph.getGridLabelRenderer().setHumanRounding(false);
    }
}*/


}
