package com.todook.myapp;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.todook.myapp.modelo.Task;

import java.util.ArrayList;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.TaskViewHolder >{
    //contruye la lista de contactos
    ArrayList<Task> tasks;
    Activity activity;
    public TaskAdapter(ArrayList<Task> tasks, Activity activity){
        this.tasks = tasks;
        this.activity = activity;
    }

    //inflar el layout y lo pasara al viewholder para que el obtenga los views
    @Override
    public TaskViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_detalle_task,parent, false );
        return new TaskViewHolder(v);
    }
    //asocia cada elemento de la lista a cada view
    @Override
    public void onBindViewHolder(TaskViewHolder taskViewHolder, int position) {
        final Task task = tasks.get(position);
        int tipo = task.getType();

        switch (tipo) {
            case 1:
                taskViewHolder.icon_type_uno.setImageResource(R.drawable.baseline_circle_green_24);
                break;
            case 2:
                taskViewHolder.icon_type_uno.setImageResource(R.drawable.baseline_circle_red_24);
                break;
            case 3:
                taskViewHolder.icon_type_uno.setImageResource(R.drawable.baseline_circle_yellow_24);
                break;
            default:
                break;
        }

        taskViewHolder.date1.setText(task.getTaskdate());
        taskViewHolder.time1.setText(task.getTimedate());
        taskViewHolder.title1.setText(task.getTaskname());

    }

    @Override
    public int getItemCount() {//cantidad de elementos de la lista
        return tasks.size();
    }
    public static class TaskViewHolder extends RecyclerView.ViewHolder{
        private final TextView date1;
        private final TextView time1;
        private final TextView title1;
        private final ImageView icon_type_uno;
        public TaskViewHolder(View itemView){
            super(itemView);
            date1 = itemView.findViewById(R.id.date1);
            time1 = itemView.findViewById(R.id.time1);
            title1 = itemView.findViewById(R.id.title1);
            icon_type_uno = itemView.findViewById(R.id.icon_type_uno);
        }

    }
}