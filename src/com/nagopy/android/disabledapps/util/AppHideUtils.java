package com.nagopy.android.disabledapps.util;

import java.util.HashSet;
import java.util.Set;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class AppHideUtils {

	@SuppressWarnings("unused")
	private Context mContext;
	private SharedPreferences sp;

	public AppHideUtils(Context context) {
		mContext = context;
		sp = PreferenceManager.getDefaultSharedPreferences(context);
	}

	/**
	 * 非表示アプリ一覧の更新
	 * @param packageName
	 *           パッケージ名
	 * @return 保存が成功すればtrue
	 */
	public boolean updateHideList(String packageName) {
		Set<String> hides = getHideAppsList();
		if (hides.contains(packageName)) {
			hides.remove(packageName);
		} else {
			hides.add(packageName);
		}
		return sp.edit().putStringSet("hides", hides).commit();
	}

	/**
	 * @return 非表示アプリ一覧
	 */
	public Set<String> getHideAppsList() {
		return sp.getStringSet("hides", new HashSet<String>());
	}

}
