package com.example.fitternitytest.view.dialog

import android.app.AlertDialog
import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import com.example.fitternitytest.R
import com.example.fitternitytest.utils.DESCRIPTION
import com.example.fitternitytest.utils.TITLE

class DetailDialog : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val view = activity?.layoutInflater?.inflate(R.layout.layout_detail_dialog, null)
        val builder = AlertDialog.Builder(activity ?: return this.dialog!!)
        builder.setView(view).setCancelable(false)

        val dialog = builder.create()
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.window?.setGravity(Gravity.CENTER)
        init(view)
        return dialog
    }

    private fun init(view: View?) {
        arguments?.apply {
            view?.findViewById<TextView>(R.id.textView_title)?.text = getString(TITLE)
            view?.findViewById<TextView>(R.id.textView_description)?.text = getString(DESCRIPTION)
        }
        view?.findViewById<TextView>(R.id.textView_OK)?.setOnClickListener { dismiss() }
    }

    class Builder {
        private var isCancellable = false
        private var title = ""
        private var description = ""

        fun title(title: String): Builder {
            this.title = title
            return this
        }

        fun description(description: String): Builder {
            this.description = description
            return this
        }

        fun isCancellable(isCancellable: Boolean): Builder {
            this.isCancellable = isCancellable
            return this
        }

        fun build(): DetailDialog {
            val fragment = DetailDialog()
            val bundle = Bundle()
            bundle.putString(TITLE, title)
            bundle.putString(DESCRIPTION, description)
            fragment.arguments = bundle
            fragment.isCancelable = isCancellable

            return fragment
        }

    }

}