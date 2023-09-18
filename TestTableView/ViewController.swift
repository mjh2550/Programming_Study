//
//  ViewController.swift
//  TestTableView
//
//  Created by Moon Jihong on 2023/09/16.
//

import UIKit

class ViewController: UIViewController {

    var tableList = ["test1","test2","test3"]
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
    }


}

extension ViewController: UITableViewDelegate, UITableViewDataSource, UIPopoverPresentationControllerDelegate {
    // MARK: - Table view data source
    
    func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return tableList.count
    }
    
    func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        let cell = tableView.dequeueReusableCell(withIdentifier: "cell", for: indexPath)

        // Configure the cell...
        cell.textLabel?.text = tableList[indexPath.row]

        return cell
    }
    
    func tableView(_ tableView: UITableView, accessoryButtonTappedForRowWith indexPath: IndexPath) {
        //팝오버 컨트롤러 생성
        let popoverController = UINavigationController(rootViewController: PopOverViewController())
        popoverController.modalPresentationStyle = .popover
        popoverController.popoverPresentationController?.delegate = self
        popoverController.popoverPresentationController?.sourceView = tableView.cellForRow(at: indexPath)
        popoverController.popoverPresentationController?.sourceRect = tableView.cellForRow(at: indexPath)?.accessoryView?.frame ?? CGRect.zero
        popoverController.preferredContentSize = CGSize(width: 200, height: 200) // 원하는 크기로 설정

    }
    
}

