//
//  MainTableViewDataSource.swift
//  TestTableView
//
//  Created by Moon Jihong on 2023/09/16.
//

import UIKit
class MainTableViewDataSource: NSObject, UITableViewDataSource {
    // MARK: - Table view data source
    
    var tableList = ["op1","op2","ex1","ex2"]

    func numberOfSections(in tableView: UITableView) -> Int {
        // #warning Incomplete implementation, return the number of sections
        return 1
    }

    func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        // #warning Incomplete implementation, return the number of rows
        return tableList.count
    }

    
    func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        let cell = tableView.dequeueReusableCell(withIdentifier: "popovercell", for: indexPath)

        // Configure the cell...
        cell.textLabel?.text = tableList[indexPath.row]

        return cell
    }
}
