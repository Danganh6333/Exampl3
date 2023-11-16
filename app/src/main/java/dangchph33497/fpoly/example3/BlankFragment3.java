package dangchph33497.fpoly.example3;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


public class BlankFragment3 extends Fragment {
    MusicListAdapter musicListAdapter;
    private List<DTO> list = new ArrayList<>();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_blank3, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.albumsList);
        musicListAdapter = new MusicListAdapter(getContext(),list);
        recyclerView.setAdapter(musicListAdapter);

        list.add(new DTO(R.drawable.pl2,"Bài hát 1","Ca Sĩ 1"));
        list.add(new DTO(R.drawable.pl2,"Bài hát 2","Ca Sĩ 2"));
        list.add(new DTO(R.drawable.pl2,"Bài hát 3","Ca Sĩ 3"));
        list.add(new DTO(R.drawable.pl2,"Bài hát 4","Ca Sĩ 4"));
        list.add(new DTO(R.drawable.pl2,"Bài hát 5","Ca Sĩ 5"));
        list.add(new DTO(R.drawable.pl2,"Bài hát 6","Ca Sĩ 6"));
        list.add(new DTO(R.drawable.pl2,"Bài hát 7","Ca Sĩ 7"));
        list.add(new DTO(R.drawable.pl2,"Bài hát 8","Ca Sĩ 8"));

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);
        return view;
    }
}