import { ProColumns, ProTable } from '@ant-design/pro-components';
import React, {useEffect, useRef} from 'react';
import { Modal } from 'antd';
import {ProFormInstance} from "@ant-design/pro-form/lib";

export type Props = {
  value: API.InterfaceInfo;
  columns: ProColumns<API.InterfaceInfo>[];
  onCancel: () => void;
  onSubmit: (values: API.InterfaceInfo) => Promise<void>;
  open: boolean;
};

const UpdateModal: React.FC<Props> = (props) => {

  const { value, columns, open, onCancel, onSubmit } = props;
  const formRef = useRef<ProFormInstance>();

  useEffect(() => {
    if (formRef) {
      formRef.current?.setFieldsValue(value);
    }
  }, [value]);

  return (
    <Modal title={'更新接口'} footer={null} open={open} onCancel={() => onCancel?.()}>
      <ProTable columns={columns} formRef={formRef} type="form" onSubmit={async (value) => onSubmit?.(value)} form={{initialValues: value}} />
    </Modal>
  );
};

export default UpdateModal;
