//
//  PopOverViewController.swift
//  TestTableView
//
//  Created by Moon Jihong on 2023/09/16.
//

import UIKit

class PopOverViewController: UIViewController {
    var mapList = ["op1", "op2","ex2"]
    
    @IBAction func onClick(_ sender: Any) {
        self.dismiss(animated: true)
    }
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
//        self.preferredContentSize = CGSize(width: 300, height: 400)
    }
    

    /*
    // MARK: - Navigation

    // In a storyboard-based application, you will often want to do a little preparation before navigation
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        // Get the new view controller using segue.destination.
        // Pass the selected object to the new view controller.
    }
    */

}

extension PopOverViewController : UITableViewDelegate, UITableViewDataSource {

    func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return mapList.count
    }

    func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        let cell = tableView.dequeueReusableCell(withIdentifier: "popovercell", for: indexPath)
        cell.textLabel?.text = mapList[indexPath.row]
        print(mapList[indexPath.row])
        return cell
    }
    
}
