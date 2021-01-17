package com.ferdinask.github.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.ferdinask.github.R
import com.ferdinask.github.adapter.UserAdapter
import com.ferdinask.github.model.user.User
import com.ferdinask.github.ui.activity.DetailActivity
import com.ferdinask.github.viewmodel.FollowViewModel
import kotlinx.android.synthetic.main.fragment_followers.*


class FollowersFragment : Fragment() {


    private lateinit var followViewModel: FollowViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_followers, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        setFollowers()
        pb.visibility = View.VISIBLE

        super.onViewCreated(view, savedInstanceState)
    }


    private fun setFollowers() {
        val user = activity?.intent?.getParcelableExtra<User>(DetailActivity.EXTRA_USER)

        if (user != null) {
            followViewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory()).get(FollowViewModel::class.java)
            followViewModel.loadFollowers(context, user.login, "0")
            followViewModel.getFollowers.observe(viewLifecycleOwner, Observer {
                rvFollowers.adapter = UserAdapter(context, it)
                rvFollowers.visibility = View.VISIBLE
                pb.visibility = View.INVISIBLE
            })
        }

        rvFollowers.layoutManager = LinearLayoutManager(context)
    }

}
